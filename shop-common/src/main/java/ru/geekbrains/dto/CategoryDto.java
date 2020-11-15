package ru.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto{

    private int id;

    private String name;

    private long productCount;

    public static CategoryDto of(Category category){
        return CategoryDto
                .builder()
                .id(category.getId())
                .name(category.getName())
                .productCount(category.getProducts().size())
                .build();
    }
}
