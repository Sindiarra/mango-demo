package net.ada.mangodemo;

import net.ada.mangodemo.category.Category;
import net.ada.mangodemo.category.CategoryRepository;
import net.ada.mangodemo.product.Product;
import net.ada.mangodemo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MangoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository productRepository,
			CategoryRepository categoryRepository
	) {
		return args -> {
			// This method can be used to run code after the application starts
			// For example, you can initialize some data or perform some checks
			System.out.println("MangoDemoApplication has started successfully!");
			// Example: Count products in the repository
			long productCount = productRepository.count();
			System.out.println("Number of products in the repository: " + productCount);
			var category = Category.builder()
					.name("Smartphone")
					.description("Mobile phone with advanced features.")
					.build();
			var category2 = Category.builder()
					.name("Tablet")
					.description("Portable touchscreen device.")
					.build();
			// Insert categories into the repository
			categoryRepository.insert(category);
			categoryRepository.insert(category2);
			var products = Product.builder()
					.name("Iphone")
					.description("Smart phone.")
					.build();
//			productRepository.insert(products);
		};
	}
}
