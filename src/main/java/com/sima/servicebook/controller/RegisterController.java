package com.sima.servicebook.controller;

import com.sima.servicebook.model.User;
import com.sima.servicebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String render(Model model, HttpSession session) {
        model.addAttribute("error", session.getAttribute("error"));
        model.addAttribute("registrationform", new User());
        return "register";
    }

    @PostMapping("/register")
    public String submit(@ModelAttribute User user, HttpSession session) {
        if (user.getHeslo().length() > 0 ) {
            userRepository.save(user);
            return "registerresult";
        } else {
            session.setAttribute("error", 1);
            return "redirect:/register";
        }

    }
}







