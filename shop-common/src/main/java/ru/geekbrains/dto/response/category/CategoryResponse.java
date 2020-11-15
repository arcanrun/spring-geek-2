package ru.geekbrains.dto.response.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String name;

    public CategoryResponse(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
