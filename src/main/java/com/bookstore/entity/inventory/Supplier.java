package com.bookstore.entity.inventory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierId;
    
    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "contact_name", length = 100)
    private String contactName;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "address")
    private String address;
}