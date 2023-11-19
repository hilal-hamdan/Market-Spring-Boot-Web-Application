package com.example.market.controllers;

import com.example.market.model.User;
import com.example.market.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping("/dash")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {

        User currentUser = dashboardService.storeUserInfoPerSession(authentication, session);

        model.addAttribute("username",currentUser.getName());
        return "dashboard.html";
    }
}