package com.example.ProductCatalogService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String description;

    private String imageUrl;

    private Double price;

    private Category category;
}
