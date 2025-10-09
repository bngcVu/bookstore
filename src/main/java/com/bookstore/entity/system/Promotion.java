package com.bookstore.entity.system;

import com.bookstore.entity.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "promotions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Integer promotionId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    private DiscountType discountType;
    
    @Column(name = "discount_value", nullable = false, precision = 10, scale = 2)
    private BigDecimal discountValue;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;
    
    @ManyToMany
    @JoinTable(
        name = "promotion_books",
        joinColumns = @JoinColumn(name = "promotion_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
    
    public enum DiscountType {
        PERCENT, FIXED
    }
}