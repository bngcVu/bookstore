package com.bookstore.entity.system;

import com.bookstore.entity.book.Book;
import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wishlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    private Integer wishlistId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column(name = "is_public")
    @Builder.Default
    private Boolean isPublic = false;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}