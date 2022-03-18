package ru.gb.gbthymeleafwinter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleafwinter.service.CartService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('cart.add')")
    public String getProductList(Model model) {
        model.addAttribute("products",
                cartService.findCartProducts());
        return "cart-product-list";
    }

    @GetMapping("/add/{productId}")
    @PreAuthorize("hasAuthority('cart.add')")
    public String addProduct(@PathVariable Long productId) {
        cartService.save(productId);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('cart.add')")
    public String deleteById(@RequestParam(name = "id") Long id) {
        cartService.deleteById(id);
        return "redirect:/cart/all";
    }
}
