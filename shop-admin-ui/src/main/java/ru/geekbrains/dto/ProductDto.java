package ru.geekbrains.dto;

import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductDto implements Serializable {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Category category;

    private Brand brand;


    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.brand = product.getBrand();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
