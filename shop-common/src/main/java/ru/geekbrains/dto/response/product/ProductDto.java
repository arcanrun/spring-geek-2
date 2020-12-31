package ru.geekbrains.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;
import ru.geekbrains.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class ProductDto {

    private Integer id;

    private String name;

    private BigDecimal price;

    private CategoryDto category;

    private BrandDto brand;

    private List<PictureDto> pictures;

    private MultipartFile[] newPictures;

    public ProductDto() {

    }

    public ProductDto(Integer id, String name, BigDecimal price, CategoryDto category, BrandDto brand, List<PictureDto> pictures, MultipartFile[] newPictures) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.pictures = pictures;
        this.newPictures = newPictures;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public void setPictures(List<PictureDto> pictures) {
        this.pictures = pictures;
    }

    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public List<PictureDto> getPictures() {
        return pictures;
    }

    public MultipartFile[] getNewPictures() {
        return newPictures;
    }
}
