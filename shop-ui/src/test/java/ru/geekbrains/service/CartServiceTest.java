package ru.geekbrains.service;

import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.dto.response.product.ProductResponse;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CartServiceTest {

    CartService cartService;

    ProductService productService;


    @BeforeEach
    public void init() {
        cartService = new CartService();
        cartService.init();
        productService = mock(ProductService.class);
    }

    @Test
    public void canWeAddProduct() throws NotFoundException {
        ProductResponse product = ProductResponse
                .builder()
                .id(1)
                .name("Air max 90")
                .price(new BigDecimal("199.12"))
                .build();

        when(productService.findById(eq(1))).thenReturn(product);

        cartService.setProductService(productService);
        cartService.addProduct(1);


        assertEquals(
                product.getId(),
                cartService.getItems().get(1).getId()
        );
        assertEquals(
                product.getPrice(),
                cartService.getItems().get(1).getItemPrice()
        );
        assertEquals(
                product.getName(),
                cartService.getItems().get(1).getProduct().getName()
        );
    }

    @Test
    public void countTotalPrice() throws NotFoundException {
        ProductResponse product1 = ProductResponse
                .builder()
                .id(1)
                .name("Air max 90")
                .price(new BigDecimal("199.12"))
                .build();

        ProductResponse product2 = ProductResponse
                .builder()
                .id(2)
                .name("Adidas Hurachi 270")
                .price(new BigDecimal("334"))
                .build();

        when(productService.findById(eq(1))).thenReturn(product1);
        when(productService.findById(eq(2))).thenReturn(product2);

        cartService.setProductService(productService);
        cartService.addProduct(1);
        cartService.addProduct(2);


        assertEquals(
                new BigDecimal("533.12"),
                cartService.getTotalPrice()
        );
    }

    @Test
    public void canWeClearCart() throws NotFoundException {
        ProductResponse product1 = ProductResponse.builder().id(1).price(new BigDecimal("1")).build();
        ProductResponse product2 = ProductResponse.builder().id(2).price(new BigDecimal("1")).build();
        ProductResponse product3 = ProductResponse.builder().id(3).price(new BigDecimal("1")).build();
        ProductResponse product4 = ProductResponse.builder().id(4).price(new BigDecimal("1")).build();
        ProductResponse product5 = ProductResponse.builder().id(5).price(new BigDecimal("1")).build();

        when(productService.findById(eq(1))).thenReturn(product1);
        when(productService.findById(eq(2))).thenReturn(product2);
        when(productService.findById(eq(3))).thenReturn(product3);
        when(productService.findById(eq(4))).thenReturn(product4);
        when(productService.findById(eq(5))).thenReturn(product5);

        cartService.setProductService(productService);

        cartService.addProduct(1);
        cartService.addProduct(2);
        cartService.addProduct(3);
        cartService.addProduct(4);
        cartService.addProduct(5);

        cartService.clear();

        assertEquals(0, cartService.getItems().values().size());
    }

    @Test
    public void removeFromCartByProductId() throws NotFoundException {
        ProductResponse product1 = ProductResponse.builder().id(1).price(new BigDecimal("1")).build();
        ProductResponse product2 = ProductResponse.builder().id(2).price(new BigDecimal("2")).build();
        ProductResponse product3 = ProductResponse.builder().id(3).price(new BigDecimal("3")).build();
        ProductResponse product4 = ProductResponse.builder().id(4).price(new BigDecimal("4")).build();
        ProductResponse product5 = ProductResponse.builder().id(5).price(new BigDecimal("5")).build();

        when(productService.findById(eq(1))).thenReturn(product1);
        when(productService.findById(eq(2))).thenReturn(product2);
        when(productService.findById(eq(3))).thenReturn(product3);
        when(productService.findById(eq(4))).thenReturn(product4);
        when(productService.findById(eq(5))).thenReturn(product5);

        cartService.setProductService(productService);

        cartService.addProduct(1);
        cartService.addProduct(2);
        cartService.addProduct(3);
        cartService.addProduct(4);
        cartService.addProduct(5);

        cartService.remove(3);
        cartService.remove(5);

        assertEquals(3, cartService.getItems().values().size());
        assertEquals(new BigDecimal("7"), cartService.getTotalPrice());
    }
}
