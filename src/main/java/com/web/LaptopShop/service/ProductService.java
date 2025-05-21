package com.web.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProduct() {
        return this.productRepository.findAll();
    }

    public Product detailProduct(long id) {
        return this.productRepository.findById(id);
    }
}
