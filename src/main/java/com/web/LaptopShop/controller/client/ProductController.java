package com.web.LaptopShop.controller.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.LaptopShop.domain.Cart;
import com.web.LaptopShop.domain.CartDetail;
import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/admin/product")
    public String getMethodName(Model model, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Product> pageProduct = this.productService.listProduct(pageable);
        List<Product> products = pageProduct.getContent();
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageProduct.getTotalPages());
        return "admin/product/show";
    }

    @GetMapping("/product/{id}")
    public String detailProduct(Model model, @PathVariable long id) {
        Product product = this.productService.detailProduct(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String idStr = (String) session.getAttribute("id");
        long id = Long.parseLong(idStr);
        List<CartDetail> products = this.productService.cartInfo(id);
        model.addAttribute("products", products);
        return "client/cart/show";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(HttpServletRequest request, @PathVariable long id) {
        this.productService.addProductToCart(request, id);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String filterProduct(Model model, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<Product> pageProduct = this.productService.listProduct(pageable);
        List<Product> products = pageProduct.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageProduct.getTotalPages());
        model.addAttribute("products", products);
        return "client/product/FilterProduct";
    }

}
