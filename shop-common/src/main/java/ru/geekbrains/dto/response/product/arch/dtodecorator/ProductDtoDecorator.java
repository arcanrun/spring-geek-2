package ru.geekbrains.dto.response.product.arch.dtodecorator;

import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDtoDecorator implements ProductDto {

    ProductDto productDto;

    public ProductDtoDecorator(ProductDto productDto) {
        this.productDto = productDto;
    }

    @Override
    public void setId(Integer id) {
        productDto.setId(id);
    }

    @Override
    public void setName(String name) {
        productDto.setName(name);
    }

    @Override
    public void setPrice(BigDecimal price) {
        productDto.setPrice(price);
    }

    @Override
    public void setCategory(CategoryDto category) {
        productDto.setCategory(category);
    }

    @Override
    public void setBrand(BrandDto brand) {
        productDto.setBrand(brand);
    }

    @Override
    public void setPictures(List<PictureDto> pictures) {
        productDto.setPictures(pictures);
    }

    @Override
    public void setNewPictures(MultipartFile[] newPictures) {
        productDto.setNewPictures(newPictures);
    }

    @Override
    public Integer getId() {
        return productDto.getId();
    }

    @Override
    public String getName() {
        return productDto.getName();
    }

    @Override
    public BigDecimal getPrice() {
        return productDto.getPrice();
    }

    @Override
    public CategoryDto getCategory() {
        return productDto.getCategory();
    }

    @Override
    public BrandDto getBrand() {
        return productDto.getBrand();
    }

    @Override
    public List<PictureDto> getPictures() {
        return productDto.getPictures();
    }

    @Override
    public MultipartFile[] getNewPictures() {
        return productDto.getNewPictures();
    }
}
