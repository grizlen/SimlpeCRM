package ru.geekbrains.simplecrm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private Integer quantity;
}
