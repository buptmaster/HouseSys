package com.housesys.demo.controller;

import com.housesys.demo.model.User;
import com.housesys.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        User user = userRepository.findUserByUsername(username);


        if(user!=null && user.getPassword().equals(password)){
            ModelAndView m = new ModelAndView("redirect:/house/my");
            m.addObject("error", 0);
            m.addObject("username", username);
            return m;
        }

        ModelAndView m = new ModelAndView("login");
        m.addObject("error", 1);
        return m;

    }

    @PostMapping("/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("phone")String phone,
                           Model model){
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setUsername(username);
        user.setType("normal");
        userRepository.save(user);

        return "login";
    }
}
