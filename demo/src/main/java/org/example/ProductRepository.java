package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository(){
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public Product deleteProductById(long id){
        Product product = products.stream().filter(x -> x.getId() == id).findFirst().get();
        products.remove(product);
        return product;
    }
    public void changeProduct(int id, Product newProduct){
        Product oldProduct = products.stream().filter(x -> x.getId() == id).findFirst().get();
        int oldProductId = products.indexOf(oldProduct);
        products.set(oldProductId, newProduct);
    }
    public Optional<Product> getProductById(long id){
        return products.stream().filter(x -> x.getId() == id).findFirst();
    }
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    
}