package ru.geekbrains.dto;


import ru.geekbrains.model.Category;

import java.io.Serializable;

public class CategoryDto{

    private int id;

    private String name;

    private long productCount;

    public CategoryDto(int id, String name, long productCount) {
        this.id = id;
        this.name = name;
        this.productCount = productCount;
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }
}
