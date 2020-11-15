package ru.geekbrains.controller;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {

    CartService cart;

    ProductService productService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cart= cartService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String cartPage(Model model) {
        log.info("items={}", cart.getItems().values());
        model.addAttribute("items", cart.getItems().values());
        return "cart";
    }

    @GetMapping("/add")
    public void addProductToCart(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException, NotFoundException {
        cart.addProduct(id);
        response.sendRedirect(request.getHeader("referer"));
    }


}
