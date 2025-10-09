package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "review_replies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewReply {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Integer replyId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}