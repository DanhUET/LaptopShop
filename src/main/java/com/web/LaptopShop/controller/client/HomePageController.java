package com.web.LaptopShop.controller.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.web.LaptopShop.domain.Product;
import com.web.LaptopShop.domain.User;
import com.web.LaptopShop.domain.dto.RegisterDTO;
import com.web.LaptopShop.repository.ProductRepository;
import com.web.LaptopShop.service.ProductService;
import com.web.LaptopShop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomePageController {
    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    private ProductService productService;
    private ProductRepository productRepository;

    public HomePageController(UserService userService, PasswordEncoder passwordEncoder, ProductService productService,
            ProductRepository productRepository) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("newUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute("newUser") @Valid RegisterDTO registerDTO, BindingResult bindingResult) {
        List<FieldError> errors = bindingResult.getFieldErrors();

        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }

        if (bindingResult.hasErrors() || this.userService.checkEmail(registerDTO.getEmail())
                || !this.userService.checkPassword(registerDTO.getPassword(), registerDTO.getConfirmPassword())) {
            return "client/auth/register";
        }
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        String password = this.passwordEncoder.encode(registerDTO.getPassword());
        user.setPassword(password);
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "client/auth/login";
    }

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 8);

        Page<Product> pageProduct = this.productService.listProduct(pageable);
        List<Product> products = pageProduct.getContent();
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageProduct.getTotalPages());
        return "client/home/show";
    }

    @GetMapping("/access-deny")
    public String accessDeny() {
        return "client/auth/deny";
    }

    @GetMapping("/userInfo/{id}")
    public String userInfo() {
        return "client/userInfo/show";
    }

}
