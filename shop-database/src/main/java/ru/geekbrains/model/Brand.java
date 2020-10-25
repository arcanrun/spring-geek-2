package ru.geekbrains.model;


import javax.persistence.*;
import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    public Brand(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<Product> getProducts() {
        return products;
    }
}
