package com.housesys.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(Model model, @RequestParam("name") String userName){
        model.addAttribute("name", userName);
        return "hello";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/house";
    }
}
