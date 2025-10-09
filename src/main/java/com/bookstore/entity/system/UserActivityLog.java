package com.bookstore.entity.system;

import com.bookstore.entity.book.Book;
import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_activity_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserActivityLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "action", length = 100)
    private String action;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column(name = "ip_address", length = 50)
    private String ipAddress;
    
    @Column(name = "device", length = 100)
    private String device;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}