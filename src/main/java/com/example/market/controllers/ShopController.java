package com.example.market.controllers;
import com.example.market.model.IphoneMobile;
import com.example.market.repository.IphoneMobileRepository;
import com.example.market.service.ShopService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shop")
    public String displayShopPage(Model model) {
        List<IphoneMobile> iphoneList = shopService.getIphonesList();
        model.addAttribute("iphoneList", iphoneList);
        return "shop";
    }

}
