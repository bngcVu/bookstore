package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "support_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportTicket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "subject", length = 150)
    private String subject;
    
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private TicketStatus status = TicketStatus.OPEN;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public enum TicketStatus {
        OPEN, IN_PROGRESS, CLOSED
    }
}