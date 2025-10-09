package com.bookstore.entity.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    
    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;
    
    @Column(name = "method", length = 50)
    private String method;
    
    @Column(name = "status", length = 50)
    private String status;
    
    @Column(name = "transaction_code", length = 100)
    private String transactionCode;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}