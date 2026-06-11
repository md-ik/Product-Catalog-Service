package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.dtos.ProductDto;
import com.example.ProductCatalogService.dtos.ProductUpdateDto;
import com.example.ProductCatalogService.dtos.CategoryDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.services.IProductService;
import com.example.ProductCatalogService.services.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public List<ProductDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products
                .stream()
                //.map((product)->from(product))
                .map(this::from)
                .collect(Collectors.toList());
    }

    @GetMapping("product/{id}")
    public  ProductDto getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return from(product);
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto input) {
        return input;
    }

    @PutMapping("/product/{id}")
    public ProductDto replaceProduct(
            @RequestBody ProductDto productDto,
            @PathVariable Long id){
        return from(
                productService.replaceProduct(from(productDto),id)
        );
    }

    @PatchMapping("product/{id}")
    //public ProductDto updateProduct(
    public ResponseEntity<ProductDto> updateProduct(
            @RequestBody ProductUpdateDto productUpdateDto,
            @PathVariable Long id
    ){
        Product updatedProduct =  productService.updateProduct(from(productUpdateDto),id);
        //return from(updatedProduct);
        return ResponseEntity.ok(from(updatedProduct));
    }

    @DeleteMapping("product/{id}")
    public  ProductDto deleteProduct(@PathVariable Long id){
        return null;
    }
    private Product from(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        if (productDto.getCategoryDto() != null) {
            product.setCategory(from(productDto.getCategoryDto()));
        }
        return product;

    }

    private Category from(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }
    private  ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());

        if (product.getCategory() != null) {
            productDto.setCategoryDto(from(product.getCategory()));
        }

        return productDto;
    }

    private CategoryDto from(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }

    private ProductUpdateDto productUpdateDtoFrom(Product product){
        ProductUpdateDto productUpdateDto = new ProductUpdateDto();

        productUpdateDto.setId(product.getId());
        productUpdateDto.setName(product.getName());
        productUpdateDto.setDescription(product.getDescription());
        productUpdateDto.setImageUrl(product.getImageUrl());
        productUpdateDto.setPrice(product.getPrice());

        if (product.getCategory() != null) {
            productUpdateDto.setCategoryDto(from(product.getCategory()));
        }

        return productUpdateDto;
    }
    private Product from(ProductUpdateDto productUpdateDto){
          Product product = new Product();
          product.setId(productUpdateDto.getId());
          product.setDescription(productUpdateDto.getDescription());
          product.setName(productUpdateDto.getName());
          product.setImageUrl(productUpdateDto.getImageUrl());
          product.setPrice(productUpdateDto.getPrice());
          product.setCategory(from(productUpdateDto.getCategoryDto()));
          return product;
    }
}
