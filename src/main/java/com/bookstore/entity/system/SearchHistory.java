package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private Integer searchId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "keyword")
    private String keyword;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}