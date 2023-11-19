package com.example.market.controllers;



import com.example.market.model.Bid;
import com.example.market.model.IphoneMobile;
import com.example.market.model.UserProfile;
import com.example.market.service.BidService;
import com.example.market.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private BidService bidService;

    @GetMapping("/displayProfile")
    public ModelAndView displayUserProfile(HttpSession session) {

        UserProfile userProfile = userProfileService.getUserProfile(session);

        ModelAndView modelAndView = new ModelAndView("userProfile.html");
        modelAndView.addObject("userProfile", userProfile);
        return modelAndView;
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile, Errors errors, HttpSession session) {

        if (errors.hasErrors())
            return "userProfile.html";

        userProfileService.updateUserProfile(userProfile,session);

        return "redirect:/displayProfile";
    }

    @GetMapping("/displayBidsList")
    public ModelAndView displayBidsList(HttpSession session){
        List<Bid> userBidsList = userProfileService.getUserBidList(session);
        ModelAndView modelAndView = new ModelAndView("bidslist.html");
        modelAndView.addObject("bidslist", userBidsList);
        return modelAndView;
    }




}
