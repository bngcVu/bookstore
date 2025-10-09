package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_vouchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVoucher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_voucher_id")
    private Integer userVoucherId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "voucher_code", length = 50)
    private String voucherCode;
    
    @Column(name = "discount_value", precision = 10, scale = 2)
    private BigDecimal discountValue;
    
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    
    @Column(name = "is_used")
    @Builder.Default
    private Boolean isUsed = false;
}