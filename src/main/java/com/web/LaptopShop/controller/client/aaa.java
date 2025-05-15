package com.web.LaptopShop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class aaa {
    @GetMapping("/")
    public String getMethodName() {
        return "admin/dashboard/show";
    }

}
