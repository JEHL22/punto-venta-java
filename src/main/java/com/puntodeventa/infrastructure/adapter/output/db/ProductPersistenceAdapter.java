package com.puntodeventa.infrastructure.adapter.output.db;

import com.puntodeventa.application.ports.output.ProductRepositoryPort;
import com.puntodeventa.domain.model.Product;
import org.springframework.stereotype.Component;

@Component 
public class ProductPersistenceAdapter implements ProductRepositoryPort {

    private final JpaProductRepository jpaProductRepository;

    public ProductPersistenceAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        // 1. Convertir Dominio -> Entidad
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setPrice(product.getPrice()); 
        entity.setStock(product.getStock());

        // 2. Guardar en DB
        ProductEntity savedEntity = jpaProductRepository.save(entity);

        // 3. Devolver el modelo actualizado
        product.setId(savedEntity.getId());
        return product;
    }
}