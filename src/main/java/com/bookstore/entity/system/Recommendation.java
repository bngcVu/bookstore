package com.bookstore.entity.system;

import com.bookstore.entity.book.Book;
import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id")
    private Integer recId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column(name = "score")
    private Float score;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}