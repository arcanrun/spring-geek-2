package ru.geekbrains.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public Optional<ProductDto> findById(int id) {
        return productRepository.findById(id).map(ProductDto::new);
    }


    @Transactional
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }


    @Transactional
    public void save(ProductDto productDto) throws IOException, NotFoundException {
        Product product = (productDto.getId() != null) ? productRepository.findById(productDto.getId())
                .orElseThrow(()-> new NotFoundException("Prodcut not found")) : new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);
    }
}
