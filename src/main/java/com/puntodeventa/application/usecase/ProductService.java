package com.puntodeventa.application.usecase;

import com.puntodeventa.application.ports.input.CreateProductUseCase;
import com.puntodeventa.application.ports.output.ProductRepositoryPort;
import com.puntodeventa.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CreateProductUseCase {

    private final ProductRepositoryPort productRepository;

    // Constructor manual (reemplaza a @RequiredArgsConstructor)
    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        if (product.getPrice().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new RuntimeException("El precio no puede ser negativo");
        }
        return productRepository.save(product);
    }
}