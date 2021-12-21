package ru.geekbrains.simplecrm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private Integer price;
}
