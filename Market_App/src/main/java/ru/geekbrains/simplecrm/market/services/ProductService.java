package ru.geekbrains.simplecrm.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.market.model.Products;
import ru.geekbrains.simplecrm.market.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Products> getAll() {
        return productRepository.findAll();
    }
}
