package ru.geekbrains.simplecrm.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.exceptions.ResourceNotFoundException;
import ru.geekbrains.simplecrm.market.model.Product;
import ru.geekbrains.simplecrm.market.model.dto.ProductDTO;
import ru.geekbrains.simplecrm.market.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public Page<ProductDTO> getAll(Integer page) {
        PageRequest pr = PageRequest.of(page, PAGE_SIZE);
        return productRepository.findAll(pr).map(this::productToDTO);
    }

    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id: " + id + " not found.")
        );
        return productToDTO(product);
    }

    private ProductDTO productToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
