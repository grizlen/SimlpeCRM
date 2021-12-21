package ru.geekbrains.simplecrm.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.model.dto.ProductDTO;
import ru.geekbrains.simplecrm.services.ProductService;

@RestController
@RequestMapping("/api/v1/market/products")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDTO> getAll(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        log.info("getAll");
        return productService.getAll(page < 0 ? 0 : page);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
