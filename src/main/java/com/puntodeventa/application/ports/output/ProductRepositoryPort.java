package com.puntodeventa.application.ports.output;

import com.puntodeventa.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
}