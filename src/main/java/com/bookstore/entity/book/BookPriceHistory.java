package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_price_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookPriceHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column(name = "old_price", precision = 10, scale = 2)
    private BigDecimal oldPrice;
    
    @Column(name = "new_price", precision = 10, scale = 2)
    private BigDecimal newPrice;
    
    @CreationTimestamp
    @Column(name = "changed_at")
    private LocalDateTime changedAt;
}