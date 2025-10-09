package com.bookstore.entity.inventory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "warehouses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Integer warehouseId;
    
    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city", length = 100)
    private String city;
    
    @Column(name = "province", length = 100)
    private String province;
}