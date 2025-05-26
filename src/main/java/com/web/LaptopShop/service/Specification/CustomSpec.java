package com.web.LaptopShop.service.Specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.domain.Product_;

public class CustomSpec {

    public static Specification<Product> namelike(String factory) {
        return (root, query, builder) -> builder.like(root.get(Product_.FACTORY), "%" +
                factory + "%");

    }

    public static Specification<Product> matchListFactory(List<String> factory) {
        return (root, query, builder) -> builder.in(root.get(Product_.FACTORY)).value(factory);
    }

    public static Specification<Product> matchListTarget(List<String> target) {
        return (root, query, builder) -> builder.in(root.get(Product_.TARGET)).value(target);
    }

    public static Specification<Product> minPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.ge(root.get(Product_.PRICE), price);
    }

    public static Specification<Product> maxPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.le(root.get(Product_.PRICE), price);
    }

    public static Specification<Product> matchPrice(double min, double max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.gt(root.get(Product_.PRICE), min),
                criteriaBuilder.le(root.get(Product_.PRICE), max));
    }

    public static Specification<Product> matchMultiplePrice(double min, double max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Product_.PRICE), min, max);
    }

}
