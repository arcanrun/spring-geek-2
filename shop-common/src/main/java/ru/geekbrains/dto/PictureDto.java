package ru.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Picture;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PictureDto {
    private int id;

    private String name;

    private String contentType;

    public static PictureDto of(Picture picture) {
        return PictureDto.builder()
                .id(picture.getId())
                .name(picture.getName())
                .contentType(picture.getContentType())
                .build();
    }
}

