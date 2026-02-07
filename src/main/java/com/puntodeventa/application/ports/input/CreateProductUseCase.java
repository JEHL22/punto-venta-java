package com.puntodeventa.application.ports.input;

import com.puntodeventa.domain.model.Product;

public interface CreateProductUseCase {
    Product create(Product product);
}

//El sistema sabe crear productos
//Controller REST
//GraphQL
//eventos
