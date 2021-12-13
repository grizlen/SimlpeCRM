package ru.geekbrains.simplecrm.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.market.model.dto.ProductDTO;
import ru.geekbrains.simplecrm.market.services.ProductService;

@RestController
@RequestMapping("/api/v1/market/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDTO> getAll(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        return productService.getAll(page < 0 ? 0 : page);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
