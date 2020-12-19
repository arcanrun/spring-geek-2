package ru.geekbrains.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.geekbrains.dto.response.category.CategoryResponse;
import ru.geekbrains.dto.response.product.ProductResponse;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Picture;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.BrandRepository;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.ProductService;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class CategoryControllerTest {

    @MockBean
    private EurekaClient eurekaClient;

    @Autowired
    private MockMvc mvc;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    public void init() {
        InstanceInfo instanceInfo = mock(InstanceInfo.class);
        when(instanceInfo.getHomePageUrl()).thenReturn("mock-homepage-url");

        when(eurekaClient.getNextServerFromEureka(anyString(), anyBoolean()))
                .thenReturn(instanceInfo);
    }

    @Test
    public void testGetCategoryPage() throws Exception {
        Brand brand = Brand
                .builder()
                .name("Nike")
                .country("USA")
                .build();

        Category category = Category
                .builder()
                .name("shoes")
                .build();

        Product product = Product
                .builder()
                .brand(brand)
                .category(category)
                .name("Air max 90")
                .price(new BigDecimal("12"))

                .build();

        category.setProducts(new ArrayList<>(Collections.singletonList(product)));

        brandRepository.save(brand);
        categoryRepository.save(category);
        productRepository.save(product);

        mvc.perform(get("/categories"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("category"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", new BaseMatcher<List<Category>>(){

                    @Override
                    public void describeTo(Description description) {

                    }

                    @Override
                    public boolean matches(Object o) {
                        if (o instanceof List) {
                            List<CategoryResponse> list = new ArrayList<CategoryResponse>((Collection<? extends CategoryResponse>) o);
                            for (CategoryResponse c: list) {
                                if(c == null){
                                    return false;
                                }
                            }

                            CategoryResponse categoryResponse = list.get(0);
                            return categoryResponse.getId().equals(category.getId());
                        }
                        return false;
                    }
                }));
    }
}
