package com.housesys.demo.controller;

import com.housesys.demo.model.House;
import com.housesys.demo.model.User;
import com.housesys.demo.repo.BuyerRepository;
import com.housesys.demo.repo.HouseRepository;
import com.housesys.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuyerRepository buyerRepository;


    @GetMapping
    public String getAllHouses(Model model) {
        List<House> houseList = houseRepository.findAll();
        model.addAttribute("houses",houseList);
        return "houses";
    }

    @GetMapping("/my")
    public String manageMyHouses(@RequestParam(name = "username", required = false)String username,
                                 Model model){
        if(username == null || username.isEmpty()) {
            return "login";
        }
        User user = userRepository.findUserByUsername(username);
        List<House> houses = houseRepository.findHousesByUser(user);

        model.addAttribute("houses", houses);
        model.addAttribute("user", user);
        return "manage";
    }

    @PostMapping("/deleteHouse")
    public String deleteHouse(@RequestParam("id") Integer id){
        houseRepository.deleteHouseById(id);
        return "manage";
    }

    @PostMapping("/addHouse")
    public String addHouse(@RequestParam("location") String location,
                           @RequestParam("price") String price,
                           @RequestParam("builtTime") String builtTime,
                           @RequestParam("userId")Integer userId,
                           Model model) {
        User user = userRepository.findUserById(userId);
        House house = new House();
        house.setBuiltTime(builtTime);
        house.setLocation(location);
        house.setPrice(Double.valueOf(price));
        house.setSaleTime(new Date());
        house.setStatus("售卖中");
        house.setUser(user);
        houseRepository.save(house);

        model.addAttribute("user", user);
        model.addAttribute("houses", houseRepository.findAll());

        return "manage";
    }

    @ResponseBody
    @PostMapping("/houseSold")
    public String soldHouse(@RequestParam("houseId")Integer houseId){
        House house = houseRepository.findHouseById(houseId);
        house.setStatus("已成交");
        houseRepository.save(house);

        return "success";
    }
}
