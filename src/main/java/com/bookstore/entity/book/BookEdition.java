package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "book_editions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEdition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edition_id")
    private Integer editionId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private Format format;
    
    @Column(name = "isbn", length = 20)
    private String isbn;
    
    @Column(name = "publication_year")
    private Integer publicationYear;
    
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    
    @Column(name = "stock")
    @Builder.Default
    private Integer stock = 0;
    
    public enum Format {
        HARDCOVER, PAPERBACK, EBOOK
    }
}