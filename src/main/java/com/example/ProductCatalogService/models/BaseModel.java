package com.example.ProductCatalogService.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private String name;
    private Date createAt;
    private Date lastUpdatedAt;
    private State state;
}
