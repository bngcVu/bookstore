package com.bookstore.entity.system;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "membership_tiers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipTier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tier_id")
    private Integer tierId;
    
    @Column(name = "name", length = 50)
    private String name;
    
    @Column(name = "min_points")
    private Integer minPoints;
    
    @Column(name = "discount_rate", precision = 5, scale = 2)
    private BigDecimal discountRate;
}