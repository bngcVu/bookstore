package com.bookstore.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}