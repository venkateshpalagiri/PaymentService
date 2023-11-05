package com.venkatesh.PaymentService.service;

import com.venkatesh.PaymentService.entity.TransactionDetails;
import com.venkatesh.PaymentService.model.PaymentRequest;
import com.venkatesh.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;


    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info(">>>>>>>>>>>>>>>>Recording Payment Details: {}",paymentRequest);
        TransactionDetails transactionDetails=TransactionDetails.builder()
                .amount(paymentRequest.getAmount())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction Completed with Id: {}",transactionDetails.getId());
        return transactionDetails.getId();
    }

}
