package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
