package com.web.LaptopShop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String detailProduct(Model model, @PathVariable long id) {
        Product product = this.productService.detailProduct(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        List<Product> products = this.productService.listProduct();
        model.addAttribute("products", products);
        return "client/cart/show";
    }

}
