package com.puntodeventa.application.ports.input;

import com.puntodeventa.domain.model.Product;

public interface CreateProductUseCase {
    Product create(Product product);
}