package ru.geekbrains.simplecrm.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.simplecrm.market.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
