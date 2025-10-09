package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "title", length = 150)
    private String title;
    
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @Builder.Default
    private NotificationType type = NotificationType.SYSTEM;
    
    @Column(name = "is_read")
    @Builder.Default
    private Boolean isRead = false;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public enum NotificationType {
        ORDER, PROMOTION, SYSTEM
    }
}