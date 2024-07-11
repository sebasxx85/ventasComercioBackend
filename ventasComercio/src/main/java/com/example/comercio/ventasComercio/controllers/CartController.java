package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.entities.Cart;
import com.example.comercio.ventasComercio.entities.CartItem;
import com.example.comercio.ventasComercio.entities.Product;
import com.example.comercio.ventasComercio.repositories.CartRepository;
import com.example.comercio.ventasComercio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @PostMapping("/{cartId}/products")
    public Cart addProductToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();  // Crear un nuevo carrito si no se encuentra
                    return cartRepository.save(newCart);
                });

        cart.addProduct(cartItem.getProduct(), cartItem.getQuantity());
        return cartRepository.save(cart);
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public Cart removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        //Busca el carro por id
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        //Busca el producto por id
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        cart.removeProduct(product);
        return cartRepository.save(cart);
    }

}