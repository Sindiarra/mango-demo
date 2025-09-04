package net.ada.mangodemo.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {


    List<Product> findByName(String name);
     List<Product> findByDescriptionContaining(String keyword);
}
