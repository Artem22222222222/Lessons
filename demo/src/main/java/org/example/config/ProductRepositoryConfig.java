package org.example.config;

import org.example.Product;
import org.example.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductRepositoryConfig {
    @Bean
    public ProductRepository ProductRepository(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.addProduct(new Product(1, "smartphone", 2500.5));
        productRepository.addProduct(new Product(2, "TV", 5000));
        productRepository.addProduct(new Product(3, "fridge", 1325.5));
        return productRepository;
    }
}
