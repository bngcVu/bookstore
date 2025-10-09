package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer publisherId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books;
}