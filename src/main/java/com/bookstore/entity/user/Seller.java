package com.bookstore.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Integer sellerId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "shop_name", length = 100)
    private String shopName;
    
    @Column(name = "rating")
    @Builder.Default
    private Float rating = 0.0f;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}