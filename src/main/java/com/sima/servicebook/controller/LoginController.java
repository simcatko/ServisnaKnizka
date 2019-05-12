package com.sima.servicebook.controller;

import com.sima.servicebook.model.User;
import com.sima.servicebook.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String render(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            model.addAttribute("loginform", new User());
            return "login";
        } else  {
            return "redirect:/service/list";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String submit(@ModelAttribute User user, HttpSession session, Model model) {
        User user2 = userRepository.findByName(user.getMeno());

        if (user2 != null && (user2.getHeslo().equals(user.getHeslo()))) {
            session.setAttribute("user", user2);
            return "redirect:/service/list";
        } else {
            return "redirect:/login";
        }
    }
}