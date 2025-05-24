package com.web.LaptopShop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.LaptopShop.domain.Cart;
import com.web.LaptopShop.domain.CartDetail;
import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.domain.User;
import com.web.LaptopShop.repository.CartDetailRepository;
import com.web.LaptopShop.repository.CartRepository;
import com.web.LaptopShop.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public ProductService(ProductRepository productRepository, UserService userService, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public Page<Product> listProduct(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    public Product detailProduct(long id) {
        return this.productRepository.findById(id);
    }

    public List<CartDetail> productInCart() {
        return this.cartDetailRepository.findAll();
    }

    public void addProductToCart(HttpServletRequest request, long id) {
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        User user = this.userService.getUserByEmail(email);
        Cart cart = this.cartRepository.findByUser(user);
        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setSum(0);
            newCart.setUser(user);
            cart = this.cartRepository.save(newCart);

        }
        Product product = this.productRepository.findById(id);
        CartDetail cartDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);

        if (cartDetail != null) {
            cartDetail.setQuantity(cartDetail.getQuantity() + 1);
            cartDetail.setPrice(cartDetail.getPrice() + product.getPrice());
            this.cartDetailRepository.save(cartDetail);
        } else {
            cart.setSum(cart.getSum() + 1);
            CartDetail newCartDetail = new CartDetail();
            newCartDetail.setQuantity(1);
            newCartDetail.setPrice(product.getPrice());
            newCartDetail.setProduct(product);
            newCartDetail.setCart(cart);
            this.cartRepository.save(cart);
            this.cartDetailRepository.save(newCartDetail);
            session.setAttribute("sum", cart.getSum());
        }

    }

    public List<CartDetail> cartInfo(long id) {
        User user = this.userService.detailUser(id);
        Cart cart = this.cartRepository.findByUser(user);
        return this.cartDetailRepository.findByCart(cart);
    }
}
