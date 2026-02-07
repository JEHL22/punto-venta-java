package com.puntodeventa.application.ports.output;

import com.puntodeventa.domain.model.Product;
import java.util.List;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
}
//Para funcionar  necesito guardar productos