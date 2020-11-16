package ru.geekbrains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.response.product.ProductResponse;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Integer id;
    private ProductResponse product;
    private int quantity;
    private BigDecimal itemPrice;
    private BigDecimal totalPrice;

}
