package com.bookstore.entity.order;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethod {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Integer methodId;
    
    @Column(name = "name", length = 50)
    private String name;
    
    @Column(name = "description")
    private String description;
}