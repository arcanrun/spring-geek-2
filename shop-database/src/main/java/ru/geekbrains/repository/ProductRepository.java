package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
