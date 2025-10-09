package com.bookstore.entity.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private PaymentMethod method;
    
    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "PENDING";
    
    @Column(name = "transaction_code", length = 100)
    private String transactionCode;
    
    @Column(name = "paid_at")
    private LocalDateTime paidAt;
}