package ru.geekbrains.controller;

import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String categoryPage(Model model){
        model.addAttribute("categories",categoryService.findAll());
//        model.addAttribute("products", )
        return "category";
    }
}
