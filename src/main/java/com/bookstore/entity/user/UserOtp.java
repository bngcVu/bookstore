package com.bookstore.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_otp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOtp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "otp_id")
    private Integer otpId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "otp_code", length = 10)
    private String otpCode;
    
    @Column(name = "expired_at")
    private LocalDateTime expiredAt;
    
    @Column(name = "is_verified")
    @Builder.Default
    private Boolean isVerified = false;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}