package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "collections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private Integer collectionId;
    
    @Column(name = "name", length = 150)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @ManyToMany
    @JoinTable(
        name = "collection_books",
        joinColumns = @JoinColumn(name = "collection_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
}