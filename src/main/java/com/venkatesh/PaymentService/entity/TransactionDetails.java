package com.venkatesh.PaymentService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.Instant;
@Entity
@Data
@Table(name ="TRANSACTION_DETAILS" )
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "ORDER_ID")
    private long orderId;
    @Column(name = "MODE")
    private String paymentMode;
    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;
    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;
    @Column(name = "STATUS")
    private String paymentStatus;
    @Column(name = "AMOUNT")
    private long amount;
}
