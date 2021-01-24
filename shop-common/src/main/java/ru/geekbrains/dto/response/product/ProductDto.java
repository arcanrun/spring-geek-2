package ru.geekbrains.dto.response.product;

import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;

import java.math.BigDecimal;
import java.util.List;


public class ProductDto implements ru.geekbrains.dto.response.product.arch.dtodecorator.ProductDto {

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

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public void setCategory(CategoryDto category) {
        this.category = category;
    }
    @Override
    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }
    @Override
    public void setPictures(List<PictureDto> pictures) {
        this.pictures = pictures;
    }
    @Override
    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public BigDecimal getPrice() {
        return price;
    }
    @Override
    public CategoryDto getCategory() {
        return category;
    }
    @Override
    public BrandDto getBrand() {
        return brand;
    }
    @Override
    public List<PictureDto> getPictures() {
        return pictures;
    }
    @Override
    public MultipartFile[] getNewPictures() {
        return newPictures;
    }
}
