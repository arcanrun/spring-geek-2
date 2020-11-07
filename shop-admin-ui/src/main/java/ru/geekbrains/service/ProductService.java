package ru.geekbrains.service;

import javassist.NotFoundException;
import liquibase.pro.packaged.A;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.dto.request.product.ProductEditRequest;
import ru.geekbrains.dto.response.product.ProductResponse;
import ru.geekbrains.dto.response.product.ProductTableResponse;
import ru.geekbrains.model.Brand;
import ru.geekbrains.model.Category;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.BrandRepository;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    private BrandRepository brandRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public List<ProductTableResponse> findAll() {
        return productRepository.findAll().stream()
                .map(e -> {
                    return new ProductTableResponse(
                            e.getId(),
                            e.getName(),
                            e.getPrice(),
                            e.getCategory(),
                            new BrandDto(
                                    e.getBrand().getId(),
                                    e.getBrand().getName(),
                                    e.getBrand().getCountry()
                            ));
                })
                .collect(Collectors.toList());
    }


    @Transactional
    public ProductResponse findById(int id) throws NotFoundException {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Product with id=%d", id)));

        return ProductResponse.of(product);
    }


    @Transactional
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }


    @Transactional
    public void save(ProductEditRequest productDto) throws IOException, NotFoundException {
        Product product = (productDto.getId() != null) ? productRepository.findById(productDto.getId())
                .orElseThrow(() -> new NotFoundException("Prodcut not found")) : new Product();

        Category category = categoryRepository
                .findById(productDto.getCategory())
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format(
                                        "Category with provided id=%d is not found",
                                        productDto.getCategory())));

        Brand brand = brandRepository
                .findById(productDto.getBrand())
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format(
                                        "Brand with provided id=%d is not found",
                                        productDto.getBrand())));

        product.setName(productDto.getName());
        product.setCategory(category);
        product.setBrand(brand);
        product.setPrice(productDto.getPrice());

        productRepository.save(product);
    }
}
