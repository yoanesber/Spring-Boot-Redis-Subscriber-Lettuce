package com.yoanesber.spring.redis_subscriber_lettuce.event;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.yoanesber.spring.redis_subscriber_lettuce.service.OrderPaymentService;
import com.yoanesber.spring.redis_subscriber_lettuce.service.Impl.OrderPaymentServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisEventSubscriber implements MessageListener {

    @Autowired
    private final OrderPaymentService orderPaymentService = new OrderPaymentServiceImpl();

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            // Deserialize JSON message
            Map<String, Object> data = objectMapper.readValue(message.getBody(), new TypeReference<Map<String, Object>>() {});

            // Extract message data
            Object messageData = (Object) data.get("message");
            
            // Extract event type
            String event = (String) data.get("event");

            // Check if message data and event type are present
            if (messageData == null || event == null) {
                handleUnknownEvent("");
                return;
            }

            // Handle event
            switch (event) {
                case EventType.PAYMENT_FAILED:
                orderPaymentService.handlePaymentFailed(messageData);
                    break;
                case EventType.PAYMENT_SUCCESS:
                orderPaymentService.handlePaymentSuccess(messageData);
                    break;
                default:
                    handleUnknownEvent(event);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleUnknownEvent(String event) {
        System.out.println("Unknown event: " + event);
    }

}
