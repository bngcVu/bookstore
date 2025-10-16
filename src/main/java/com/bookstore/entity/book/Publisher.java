package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "PUBLISHERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer publisherId;
    
    @Column(name = "name", length = 150)
    private String name;
    
}