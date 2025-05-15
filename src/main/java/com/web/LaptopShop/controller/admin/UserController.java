package com.web.LaptopShop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.LaptopShop.domain.User;
import com.web.LaptopShop.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
    public String createUser(@ModelAttribute("newUser") User newUser) {

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
