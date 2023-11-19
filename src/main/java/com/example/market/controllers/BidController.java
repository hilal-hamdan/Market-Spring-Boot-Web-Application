package com.example.market.controllers;

import com.example.market.model.Bid;
import com.example.market.model.IphoneMobile;
import com.example.market.model.User;
import com.example.market.service.BidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class BidController {

    @Autowired
    private BidService bidService;

    private IphoneMobile iphoneMobile;

    @PostMapping("/bids/{id}")
    public String displayBidsPage(@PathVariable Integer id,
                                  Model model) {
        this.iphoneMobile = bidService.getIphoneMobile(id);
        if (iphoneMobile != null) {
            model.addAttribute("iphone", iphoneMobile);
            model.addAttribute("bidAmount", 0.0);
        }

        return "bids";
    }

    @GetMapping("/livebids")
    public String displayLiveBidsPage(Model model){
        List<IphoneMobile> iphoneList = bidService.getLiveIphoneList();
        model.addAttribute("iphoneList",iphoneList);
        for (IphoneMobile iphone : iphoneList) System.out.println(iphone.toString());
        return "livebids";
    }


    @PostMapping("/submitabid")
    public String handleFormSubmission(
            @RequestParam("bidAmount") double bidAmount,
            Model model,
            HttpSession session) {

        if(bidAmount<=this.iphoneMobile.getMaxBidAmount())
        {
        model.addAttribute("bidAmount", "Bid Amount must be greater than Max Bid Amount");
        return displayBidsPage(iphoneMobile.getIphoneId(),model);
        }
        User user = (User) session.getAttribute("loggedInUser");
        Bid bid = new Bid();
        bid.setIphoneId(iphoneMobile.getIphoneId());
        bid.setUserId(user.getUserId());
        bid.setBidAmount(bidAmount);
        bidService.addNewBid(bid);
        return "redirect:/shop";
    }



    @PostMapping("/selliphone")
    public String sellIphone(Model model,
                             @RequestParam("iphoneId") int iphoneId,
                             HttpSession session){
       if( bidService.sellIphone(iphoneId))
        return "redirect:/livebids";
        else return "livebids";
    }

}
