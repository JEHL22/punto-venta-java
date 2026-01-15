package com.puntodeventa.infrastructure.adapter.input.rest;

import com.puntodeventa.application.ports.input.CreateProductUseCase;
import com.puntodeventa.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return createProductUseCase.create(product);
    }
}