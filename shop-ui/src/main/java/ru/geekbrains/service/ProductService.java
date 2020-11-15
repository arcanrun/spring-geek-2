package ru.geekbrains.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.dto.response.product.ProductResponse;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(ProductResponse::of).collect(Collectors.toList());
    }

    public ProductResponse findById(Integer id) throws NotFoundException {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Product with id=%d does not exist", id)));
        return ProductResponse.of(product);
    }
}
