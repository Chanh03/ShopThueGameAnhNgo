package com.anhngo.shopthueaccanhngo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping()
    public String home() {
        return "home/_listGame";
    }
}
