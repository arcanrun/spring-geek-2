package ru.geekbrains.dto.response.product.arch.dtodecorator;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;

import java.math.BigDecimal;

@Slf4j
public class ProductDtoLoggingDecorator extends ProductDtoDecorator {
    ProductDtoLoggingDecorator(ProductDto productDto) {
        super(productDto);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal currentPrice = super.getPrice();
        log.info("Logging price={}", currentPrice);
        return currentPrice;
    }

    @Override
    public CategoryDto getCategory() {
        log.info("Logging category name={}", super.getCategory().getName());
        super.getCategory().setName(
                super.getCategory().getName().toUpperCase()
        );
        return super.getCategory();
    }

    @Override
    public void setBrand(BrandDto brand) {
        if (brand == null) {
            throw new IllegalArgumentException("Brand must be some value and not should not be null!!!");
        }
        log.info("On set brand, brand name is {}", brand.getName());
        super.setBrand(brand);
    }
}

