package com.bookstore.entity.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipping")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipping {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Integer shippingId;
    
    @Column(name = "recipient_name", length = 100)
    private String recipientName;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private ShippingMethod method;
    
    @Column(name = "tracking_number", length = 100)
    private String trackingNumber;
    
    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "PENDING";
    
    @Column(name = "shipped_at")
    private LocalDateTime shippedAt;
}