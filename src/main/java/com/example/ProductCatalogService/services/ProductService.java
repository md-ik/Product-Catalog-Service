package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product,Long id){
        Product oldProduct = this.getProductById(id);
        oldProduct.setCategory(product.getCategory());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setName(product.getName());
        oldProduct.setDescription(oldProduct.getDescription());
        oldProduct.setImageUrl(product.getImageUrl());
        return  oldProduct;
//        return null;
    }

    public  Product updateProduct(Product product,Long id) {
        Product oldProduct = this.getProductById(id);

        if (product.getCategory() != null) {
            oldProduct.setCategory(product.getCategory());
        }

        if (product.getPrice() != null) {
            oldProduct.setPrice(product.getPrice());
        }

        if (product.getName() != null) {
            oldProduct.setName(product.getName());
        }

        if (product.getDescription() != null) {
            oldProduct.setDescription(product.getDescription());
        }

        if (product.getImageUrl() != null) {
            oldProduct.setImageUrl(product.getImageUrl());
        }

        //return productRepository.save(oldProduct);
        return  oldProduct;
    }

    public  Product deleteProduct(Long id) {
        return null;
    }
}
