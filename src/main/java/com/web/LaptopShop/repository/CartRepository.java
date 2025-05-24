package com.web.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.LaptopShop.domain.Cart;
import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart save(Cart cart);

    Cart findByUser(User user);
}
