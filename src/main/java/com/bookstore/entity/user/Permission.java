package com.bookstore.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "PERMISSIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;
    
    @Column(name = "permission_name", nullable = false, length = 100, unique = true)
    private String permissionName;
    
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}