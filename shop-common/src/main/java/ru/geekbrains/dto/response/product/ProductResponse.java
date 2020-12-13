package ru.geekbrains.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Product;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<PictureDto> pictures;

    private MultipartFile[] newPictures;

    public static ProductResponse of(Product product) {
        CategoryDto categoryDto = CategoryDto.of(product.getCategory());
        BrandDto brandDto = BrandDto.of(product.getBrand());
        List<PictureDto> pictureDtoList = product.getPictures() == null ? null : product
                .getPictures()
                .stream()
                .map(PictureDto::of)
                .collect(Collectors.toList());

        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .category(categoryDto)
                .brand(brandDto)
                .pictures(pictureDtoList)
                .build();
    }

}
