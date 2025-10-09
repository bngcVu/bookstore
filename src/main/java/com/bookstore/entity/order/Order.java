package com.bookstore.entity.order;

import com.bookstore.entity.user.User;
import com.bookstore.entity.user.UserAddress;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @CreationTimestamp
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    
    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "PENDING";
    
    @Column(name = "total_amount", precision = 12, scale = 2)
    private BigDecimal totalAmount;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private UserAddress address;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderStatusHistory> statusHistory;
}