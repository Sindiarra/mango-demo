package net.ada.mangodemo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("productId")  String productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }


//    @PutMapping("{id}")
//    public ResponseEntity<Product> updateProduct(
//            @PathVariable("id") String id,
//            @RequestParam("name") String name,
//            @RequestParam("description") String description) {
//        return ResponseEntity.ok(productService.updateProduct(id, name, description));
//    }



}
