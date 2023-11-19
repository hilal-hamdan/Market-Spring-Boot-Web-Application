package com.example.market.controllers;

import com.example.market.model.Contact;
import com.example.market.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String saveMessage(Model model, @Valid @ModelAttribute("contact") Contact contact, Errors errors)
    {
        if(errors.hasErrors()){
            log.info("Contact form validation failed: " + errors);
            return "contact"; // Return "contact" instead of "contact.html"
        }

        contactService.saveMessageDetails(contact);

        return "redirect:/contact";
         // Redirect to the "/contact" page
    }

    @GetMapping("/aboutus")
    public String displayAboutUsPage(){
        return "aboutus";
    }

    @GetMapping("/displayInquiries")
    public ModelAndView displayInquiries(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        List<Contact> inquiriesList = contactService.findInquiriesByStatus();
        modelAndView.setViewName("inquiries");
        modelAndView.addObject("inquiriesList", inquiriesList);

        return modelAndView;
    }

    @GetMapping("/closeInquiry")
    public String closeInquiry(@RequestParam int id) {

        contactService.updateInquiryStatus(id);
        return "redirect:/displayInquiries";

    }


}
