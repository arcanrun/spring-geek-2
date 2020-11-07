package ru.geekbrains.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Product;


import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Integer id;

    private String name;

    private BigDecimal price;

    private CategoryDto category;

    private BrandDto brand;

    public static ProductResponse of(Product product){
        CategoryDto categoryDto = CategoryDto.of(product.getCategory());
        BrandDto brandDto = BrandDto.of(product.getBrand());
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .category(categoryDto)
                .brand(brandDto)
                .build();
    }

    }
