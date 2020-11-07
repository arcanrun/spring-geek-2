package ru.geekbrains.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEditRequest {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer category; // id

    private Integer brand; // id
}
