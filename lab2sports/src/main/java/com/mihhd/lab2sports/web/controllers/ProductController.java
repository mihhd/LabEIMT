package com.mihhd.lab2sports.web.controllers;

import com.mihhd.lab2sports.config.Layout;
import com.mihhd.lab2sports.model.Manufacturer;
import com.mihhd.lab2sports.model.Product;
import com.mihhd.lab2sports.service.CategoryService;
import com.mihhd.lab2sports.service.ManufacturerService;
import com.mihhd.lab2sports.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @Layout("layout/master")
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("product", new Product());
        return "forms/product.Add";
    }

    @Layout("layout/master")
    @PostMapping(value="/save")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("categories",categoryService.findAll());
        productService.save(product);
        return "common/success";
    }

    @Layout("layout/master")
    @GetMapping(value = "view/{id}")
    public String viewProduct(Model model, @PathVariable ("id") Long id){
        model.addAttribute("product", productService.findById(id));
        return "products";
    }
}
