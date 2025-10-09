package com.bookstore.entity.system;

import com.bookstore.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "table_name", length = 100)
    private String tableName;
    
    @Column(name = "record_id")
    private Integer recordId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private AuditAction action;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by")
    private User changedBy;
    
    @CreationTimestamp
    @Column(name = "changed_at")
    private LocalDateTime changedAt;
    
    public enum AuditAction {
        INSERT, UPDATE, DELETE
    }
}