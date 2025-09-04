package net.ada.mangodemo.category;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    // You can define custom query methods here if needed
    // For example, to find categories by name:
    // List<Category> findByName(String name);

    // Or to find categories by description containing a keyword:
    // List<Category> findByDescriptionContaining(String keyword);
}
