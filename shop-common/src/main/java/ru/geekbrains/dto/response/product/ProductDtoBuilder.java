package ru.geekbrains.dto.response.product;

import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDtoBuilder {
    private final ProductDto productDto;

    public ProductDtoBuilder() {
        this.productDto = new ProductDto();
    }

    public ProductDtoBuilder id(int id) {
        productDto.setId(id);
        return this;
    }

    public ProductDtoBuilder name(String name) {
        productDto.setName(name);
        return this;
    }

    public ProductDtoBuilder price(BigDecimal price) {
        productDto.setPrice(price);
        return this;
    }

    public ProductDtoBuilder category(CategoryDto catergoryDto) {
        productDto.setCategory(catergoryDto);
        return this;
    }

    public ProductDtoBuilder brand(BrandDto brandDto) {
        productDto.setBrand(brandDto);
        return this;
    }

    public ProductDtoBuilder pictures(List<PictureDto> pictures) {
        productDto.setPictures(pictures);
        return this;
    }

    public ProductDto build(){
        return this.productDto;
    }


}
