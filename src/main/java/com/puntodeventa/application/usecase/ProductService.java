package com.puntodeventa.application.usecase;

import com.puntodeventa.application.ports.input.CreateProductUseCase;
import com.puntodeventa.application.ports.output.ProductRepositoryPort;
import com.puntodeventa.domain.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
//Implements: No hereda el codigo sino que promete implementar los metodos definidos en la interfaz CreateProductUseCase
public class ProductService implements CreateProductUseCase {

    private final ProductRepositoryPort productRepository;
    //Inyección de dependencias manual (reemplaza a @RequiredArgsConstructor)
    //private: solo se usa dentro de esta clase
    //final: solo se asigna una vez.
    //ProductRepositoryPort: Interfaz que define las operaciones.
    //productRepository: Es la instancia concreta que implementa ProductRepositoryPort, se inyecta a través del constructor.

    // Constructor manual (reemplaza a @RequiredArgsConstructor)
    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }
    @Override //Metodo que implementa la interfaz CreateProductUseCase
    public Product create(Product product) {
        //REGLAS DE NEGOCIO
        //el precio no puede ser negativo
        if (product.getPrice().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new RuntimeException("El precio no puede ser negativo");
        }
        return productRepository.save(product);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }
}