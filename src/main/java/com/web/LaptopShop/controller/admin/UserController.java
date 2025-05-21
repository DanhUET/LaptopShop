package com.web.LaptopShop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.web.LaptopShop.domain.User;
import com.web.LaptopShop.service.UploadService;
import com.web.LaptopShop.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private UserService userService;
    private UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")
    public String listUser(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "admin/user/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult newUserBindingResult,
            @RequestParam("uploadFile") MultipartFile file) {
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }

        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }
        String password = this.passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(password);
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        newUser.setAvatar(avatar);
        newUser.setRole(this.userService.getRoleByName(newUser.getRole().getName()));
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/{id}")
    public String detailUser(Model model, @PathVariable long id) {

        model.addAttribute("user", this.userService.detailUser(id));
        return "admin/user/detail";

    }

    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable long id) {
        model.addAttribute("user", this.userService.detailUser(id));
        return "admin/user/update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable long id) {
        User newUser = this.userService.detailUser(id);
        newUser.setAddress(user.getAddress());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setFullName(user.getFullName());
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        return "admin/user/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/user";
    }

}
