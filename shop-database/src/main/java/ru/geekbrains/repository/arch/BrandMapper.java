package ru.geekbrains.repository.arch;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.Brand;
import javax.persistence.EntityManager;

@Component
@AllArgsConstructor
public class BrandMapper {
    private final EntityManager entityManager;

    public Brand findById(int id) {
        return entityManager.find(Brand.class, id);
    }

    public void insert(Brand brand)  {
            entityManager.persist(brand);
    }

    public void update(Brand brand) {
        entityManager.merge(brand);
    }

    public void delete(Brand brand) {
        entityManager.remove(brand);
    }
}
