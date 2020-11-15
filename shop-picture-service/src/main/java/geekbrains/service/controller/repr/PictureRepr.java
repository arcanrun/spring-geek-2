package geekbrains.service.controller.repr;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.model.Picture;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureRepr implements Serializable {

    private Integer id;

    private String name;

    private String contentType;

    public PictureRepr(Picture picture) {
        this.id = picture.getId();
        this.name = picture.getName();
        this.contentType = picture.getContentType();
    }

}
