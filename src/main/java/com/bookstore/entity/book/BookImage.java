package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOOK_IMAGES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookImage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column(name = "image_url")
    private String imageUrl;

}