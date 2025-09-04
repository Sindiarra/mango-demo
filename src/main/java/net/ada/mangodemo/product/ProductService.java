package net.ada.mangodemo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String save(Product product) {

        return productRepository.save(product).getId();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }



    public  Product findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            throw new RuntimeException("Product not found with name: " + name);
        }
        return products.get(0); // Assuming names are unique, return the first match
    }



}
