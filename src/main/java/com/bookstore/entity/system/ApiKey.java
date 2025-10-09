package com.bookstore.entity.system;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_keys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiKey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private Integer keyId;
    
    @Column(name = "app_name", length = 100)
    private String appName;
    
    @Column(name = "api_key")
    private String apiKey;
    
    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}