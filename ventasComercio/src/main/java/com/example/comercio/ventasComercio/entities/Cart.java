package com.example.comercio.ventasComercio.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter @Setter private Client client;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<CartItem> items = new HashSet<>();

    @Basic
    @Getter @Setter private Double total = 0.0; // Inicializar total a 0.0

    // Métodos para agregar y remover productos del carrito
    public void addProduct(Product product, Integer quantity) {
        CartItem item = new CartItem(this, product, quantity, product.getPrecio());
        items.add(item);
        // Actualizar el total del carrito
        updateTotal();
    }

    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
        // Actualizar el total del carrito
        updateTotal();
    }

    // Método para actualizar el total del carrito
    private void updateTotal() {
        this.total = items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
}