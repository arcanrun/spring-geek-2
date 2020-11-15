package ru.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Brand;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private Integer id;

    private String name;

    private String country;

    public static BrandDto of(Brand brand){
        return BrandDto
                .builder()
                .id(brand.getId())
                .name(brand.getName())
                .country(brand.getCountry())
                .build();
    }
}
