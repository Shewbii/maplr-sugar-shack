package fr.shewbii.maplr_sugar_shack.controller;

import fr.shewbii.maplr_sugar_shack.models.dto.CartLineDto;
import fr.shewbii.maplr_sugar_shack.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartLineDto> getCart() {
        return cartService.getCart();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addToCart(@RequestParam Integer productId) {
        cartService.addToCart(productId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeFromCart(@RequestParam Integer productId) {
        cartService.removeFromCart(productId);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeQty(@RequestParam Integer productId, @RequestParam Integer newQty) {
        cartService.changeQty(productId, newQty);
    }

}
