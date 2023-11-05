package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

}
