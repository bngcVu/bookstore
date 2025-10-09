package com.bookstore.entity.order;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shipping_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingRate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Integer rateId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private ShippingMethod method;
    
    @Column(name = "province", length = 100)
    private String province;
    
    @Column(name = "base_fee", precision = 10, scale = 2)
    private BigDecimal baseFee;
    
    @Column(name = "weight_fee", precision = 10, scale = 2)
    private BigDecimal weightFee;
}