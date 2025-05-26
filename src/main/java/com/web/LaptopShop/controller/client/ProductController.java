package com.web.LaptopShop.controller.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.LaptopShop.domain.Cart;
import com.web.LaptopShop.domain.CartDetail;
import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.domain.Product_;
import com.web.LaptopShop.service.ProductService;
import com.web.LaptopShop.service.Specification.CustomSpec;

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
    public String filterProduct(Model model, @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "factory", required = false) String factory,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "target", required = false) String target,
            @RequestParam(value = "radio-sort", required = false) String sort) {
        if (page == null) {
            page = 1;
        }
        Specification<Product> combinedSpec = Specification.where(null);
        Pageable pageable = PageRequest.of(page - 1, 6);
        if (factory == null && price == null && target == null) {

        }
        if (sort != null) {
            if (sort.equals("gia-tang-dan"))
                pageable = PageRequest.of(page - 1, 6, Sort.by(Product_.PRICE).ascending());
            if (sort.equals("gia-giam-dan"))
                pageable = PageRequest.of(page - 1, 6, Sort.by(Product_.PRICE).descending());
        }
        if (factory != null) {
            List<String> listFactory = Arrays.asList(factory.split(","));
            Specification<Product> matchListFactory = CustomSpec.matchListFactory(listFactory);
            combinedSpec = combinedSpec.and(matchListFactory);
        }
        if (target != null) {
            List<String> listTarget = Arrays.asList(target.split(","));

            Specification<Product> matchListTarget = CustomSpec.matchListTarget(listTarget);

            combinedSpec = combinedSpec.and(matchListTarget);
        }
        if (price != null) {
            List<String> listPrice = Arrays.asList(price.split(","));
            Specification<Product> currentSpec = this.buildPriceSpecification(listPrice);
            combinedSpec = combinedSpec.and(currentSpec);
        }
        Page<Product> pageProduct = this.productService.filterProduct(combinedSpec, pageable);
        List<Product> products = pageProduct.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageProduct.getTotalPages());
        model.addAttribute("products", products);
        return "client/product/FilterProduct";
    }

    public Specification<Product> buildPriceSpecification(List<String> price) {
        Specification<Product> combinedSpec = Specification.where(null);
        for (String p : price) {
            double min = 0;
            double max = 0;

            // Set the appropriate min and max based on the price range string
            switch (p) {
                case "duoi-10-trieu":
                    min = 1;
                    max = 10000000;
                    break;
                case "10-15-trieu":
                    min = 10000000;
                    max = 15000000;
                    break;
                case "15-20-trieu":
                    min = 15000000;
                    max = 20000000;
                    break;
                case "tren-20-trieu":
                    min = 20000000;
                    max = 200000000;
                    break;
            }

            if (min != 0 && max != 0) {
                Specification<Product> rangeSpec = CustomSpec.matchMultiplePrice(min, max);
                combinedSpec = combinedSpec.or(rangeSpec);
            }
        }

        return combinedSpec;
    }

}
