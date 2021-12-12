package ru.geekbrains.simplecrm.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.simplecrm.market.model.Products;
import ru.geekbrains.simplecrm.market.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/market/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Products> getAll() {
        return productService.getAll();
    }
}
