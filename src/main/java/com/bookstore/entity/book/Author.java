package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "AUTHORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;
    
    @Column(name = "name", length = 150)
    private String name;
    
}