package com.yoanesber.spring.redis_subscriber_lettuce.service;

public interface OrderPaymentService {
    // Handle payment failed event
    void handlePaymentFailed(Object orderPayment);

    // Handle payment success event
    void handlePaymentSuccess(Object orderPayment);
}
