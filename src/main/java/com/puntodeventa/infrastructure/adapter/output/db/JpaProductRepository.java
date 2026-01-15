package com.puntodeventa.infrastructure.adapter.output.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    // Aquí no necesitas escribir código, Spring lo hace por ti
}