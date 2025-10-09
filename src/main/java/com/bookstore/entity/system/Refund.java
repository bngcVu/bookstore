package com.bookstore.entity.system;

import com.bookstore.entity.order.Order;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "refunds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refund {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refund_id")
    private Integer refundId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private RefundStatus status = RefundStatus.REQUESTED;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public enum RefundStatus {
        REQUESTED, APPROVED, REJECTED, COMPLETED
    }
}