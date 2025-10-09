package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;
    
    @Column(name = "dob")
    private LocalDate dob;
    
    @Column(name = "nationality", length = 100)
    private String nationality;
    
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books;
}