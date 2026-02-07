package com.puntodeventa.infrastructure.adapter.input.rest;

import com.puntodeventa.application.ports.input.CreateProductUseCase;
import com.puntodeventa.application.usecase.ProductService;
import com.puntodeventa.domain.model.Product;
import com.puntodeventa.infrastructure.adapter.input.rest.dto.ProductRequest;
import com.puntodeventa.infrastructure.adapter.input.rest.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
//Genera constuctor automatico con los campos finales (final) de la clase
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ProductService productService;

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        // 1. Convertir DTO (Web) -> Dominio
        Product newProduct = new Product(null, request.getName(), request.getPrice(), request.getStock());

        // 2. Llamar al Caso de Uso
        Product createdProduct = createProductUseCase.create(newProduct);

        // 3. Convertir Dominio -> DTO (Web)
        return new ProductResponse(createdProduct.getId(), createdProduct.getName(), createdProduct.getPrice(), createdProduct.getStock());
    }

    @GetMapping
    public List<ProductResponse> list() {
        // Obtener todos los productos del servicio y convertir a DTO
        return productService.listAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getStock()))
                .collect(Collectors.toList());
    }
}