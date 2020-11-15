package ru.geekbrains.dto.response.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTableResponse {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Category category;

    private BrandDto brand;
}
