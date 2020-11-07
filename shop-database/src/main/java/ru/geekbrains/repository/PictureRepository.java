package ru.geekbrains.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
