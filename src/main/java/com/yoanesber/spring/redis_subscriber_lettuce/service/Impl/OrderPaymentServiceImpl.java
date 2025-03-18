package com.yoanesber.spring.redis_subscriber_lettuce.service.Impl;

import org.springframework.stereotype.Service;

import com.yoanesber.spring.redis_subscriber_lettuce.service.OrderPaymentService;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Override
    public void handlePaymentFailed(Object orderPayment) {
        System.out.println("Payment failed: " + orderPayment);

        // add logic to handle payment failure
    }

    @Override
    public void handlePaymentSuccess(Object orderPayment) {
        System.out.println("Payment success: " + orderPayment);

        // add logic to handle payment success
    }

}
