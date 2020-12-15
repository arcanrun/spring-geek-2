package ru.geekbrains.service;

import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.dto.response.product.ProductResponse;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    Product product;

    Brand brand;

    Category category;

    @BeforeEach
    public void init(){
        brand = Brand
                .builder()
                .id(1)
                .name("Nike")
                .country("USA")
                .build();

        category = Category
                .builder()
                .id(1)
                .name("shoes")
                .build();

        product = Product
                .builder()
                .id(1)
                .brand(brand)
                .category(category)
                .name("Air max 90")
                .price(new BigDecimal("12"))
                .build();

        category.setProducts(new ArrayList<>(Collections.singletonList(product)));

        when(productRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(product));
        when(productRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(product, product, product)));
    }

    @Test
    public void testFindById() throws NotFoundException {
       ProductResponse productResponse = productService.findById(1);

       assertEquals("Air max 90", productResponse.getName());
       assertEquals(new BigDecimal("12"), productResponse.getPrice());
    }

    @Test
    public void testFindAllTest() throws NotFoundException {
        List<ProductResponse> productResponse = productService.findAll();

        assertEquals(3, productResponse.size());
        assertEquals(new BigDecimal("12"), productResponse.get(2).getPrice());
    }
}
