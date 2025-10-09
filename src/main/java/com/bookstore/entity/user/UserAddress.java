package com.bookstore.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "label", length = 50)
    private String label;
    
    @Column(name = "address_detail")
    private String addressDetail;
    
    @Column(name = "city", length = 100)
    private String city;
    
    @Column(name = "province", length = 100)
    private String province;
    
    @Column(name = "is_default")
    @Builder.Default
    private Boolean isDefault = false;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}