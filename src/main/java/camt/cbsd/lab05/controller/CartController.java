package camt.cbsd.lab05.controller;

import camt.cbsd.lab05.entity.security.Cart;
import camt.cbsd.lab05.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<?> getAllCarts() {
        List<Cart> carts = this.cartService.getAllCarts();
        if (carts.size() != 0) {
            return ResponseEntity.ok(carts);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
