package com.housesys.demo.controller;

import com.housesys.demo.model.Buyer;
import com.housesys.demo.repo.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerRepository buyerRepository;

    @ResponseBody
    @PostMapping("/add")
    public String addBuyer(@RequestParam("idNumber") String idNumber,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone,
                           @RequestParam("houseId") Integer houseId) {
        Buyer buyer = new Buyer();
        buyer.setIdNumber(idNumber);
        buyer.setName(name);
        buyer.setPhone(phone);
        buyer.setHouseId(houseId);

        try {
            buyerRepository.save(buyer);
        } catch (Exception e) {
            return "fail";
        }

        return "success";
    }

    @GetMapping("/house")
    public String buyerHouse(@RequestParam("houseId") Integer id,
                             Model model) {
        List<Buyer> buyers = buyerRepository.findBuyersByHouseId(id);
        if(buyers == null) buyers = Collections.emptyList();
        model.addAttribute("buyers", buyers);
        return "detail_table";
    }

    @ResponseBody
    @PostMapping("/ignore")
    public String ignoreBuyer(@RequestParam("idNumber")String idNumber){
        buyerRepository.deleteBuyerByIdNumber(idNumber);
        return "success";
    }
}
