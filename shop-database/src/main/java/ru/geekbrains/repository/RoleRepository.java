package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.Role;

import java.util.List;
import java.util.Set;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Set<Role> findAllByIdIn(List<Integer> idList);
}
