package com.example.ProductCatalogService.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Category {
    private String description;
    private List<Product> list;
}
