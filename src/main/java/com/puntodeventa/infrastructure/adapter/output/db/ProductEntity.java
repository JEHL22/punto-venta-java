package com.puntodeventa.infrastructure.adapter.output.db;

import jakarta.persistence.*;
import java.math.BigDecimal; // Importante
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(precision = 10, scale = 2) // Recomendado para dinero
    private BigDecimal price; // Cambia de Double a BigDecimal

    private Integer stock;
}