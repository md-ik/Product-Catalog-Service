package com.example.ProductCatalogService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ProductCatalogService.models.Category;

@SpringBootApplication
public class ProductCatalogServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProductCatalogServiceApplication.class, args);
        System.out.println("java project on intelije");
        Category category = new Category();
        System.out.println(category.getList());
	}

}
