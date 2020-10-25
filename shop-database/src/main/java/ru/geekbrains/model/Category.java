package ru.geekbrains.model;


import javax.persistence.*;
import java.util.List;

@Table(name = "categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
