package ru.geekbrains.service;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.OrderItem;
import ru.geekbrains.dto.response.product.ProductResponse;
import ru.geekbrains.model.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private Map<Integer, OrderItem> items;

    @PostConstruct
    public void init() {
        items = new HashMap<>();
    }

    public Map<Integer, OrderItem> getItems() {
        return this.items;
    }

    public BigDecimal getTotalPrice() {
       return items
               .values()
               .stream()
               .map(OrderItem::getTotalPrice)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(int productId) throws NotFoundException {
        ProductResponse product = productService.findById(productId);
        OrderItem item = items.get(product.getId());
        if (item == null) {
            item = new OrderItem();
            item.setId(productId);
            item.setItemPrice(product.getPrice());
            item.setProduct(product);
            item.setQuantity(0);
        }
        item.setQuantity(item.getQuantity() + 1);
        item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
        items.put(product.getId(), item);
    }

    public void clear(){
        this.items.clear();
    }

    public void remove(Integer productId){
        this.items.remove(productId);
    }

}
