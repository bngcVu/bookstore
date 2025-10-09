package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "loyalty_points")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoyaltyPoint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Integer pointId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "points")
    @Builder.Default
    private Integer points = 0;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}