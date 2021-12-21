package ru.geekbrains.simplecrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.simplecrm.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
