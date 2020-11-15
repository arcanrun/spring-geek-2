package ru.geekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pictures_data")
public class PictureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Lob
    @Type(type="org.hibernate.type.BinaryType") // для правильной работы PostgreSQL
    @Column(name = "data", length = 33554430) // для правильной hibernate-валидации в MySQL
    private byte[] data;

    @Column
    private String fileName;

    public PictureData(byte[] data) {
        this.data = data;
    }

    public PictureData(String fileName) {
        this.fileName = fileName;
    }

}
