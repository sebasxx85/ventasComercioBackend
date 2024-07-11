package com.example.comercio.ventasComercio.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
    public class CartItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter @Setter private Long id;

        @ManyToOne
        @JoinColumn(name = "cart_id")
        @Getter @Setter private Cart cart;

        @ManyToOne
        @JoinColumn(name = "product_id")
        @Getter @Setter private Product product;

        @Basic
        @Getter @Setter private Integer quantity;

        @Basic
        @Getter @Setter private Double price;

    public CartItem(Cart cart, Product product, Integer quantity, Double price) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}

