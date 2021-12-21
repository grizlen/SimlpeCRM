package ru.geekbrains.simplecrm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Long price;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "paid")
    private LocalDateTime paid;

    @Column(name = "delivered")
    private LocalDateTime delivered;
}
