package com.bookstore.entity.book;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;
    
    @Column(name = "tag_name", unique = true, length = 50)
    private String tagName;
    
    @ManyToMany(mappedBy = "tags")
    private Set<Book> books;
}