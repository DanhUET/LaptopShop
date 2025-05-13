package com.web.LaptopShop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class aaa {
    @GetMapping("/a")
    public String getMethodName() {
        return "client/hello";
    }

}
