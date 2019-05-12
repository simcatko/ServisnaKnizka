package com.sima.servicebook.controller;

import com.sima.servicebook.model.Service;
import com.sima.servicebook.model.User;
import com.sima.servicebook.repository.ClientRepository;
import com.sima.servicebook.repository.ServiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ServiceController {

    private final ServiceRepository serviceRepository;
    private final ClientRepository clientRepository;

    public ServiceController(ServiceRepository serviceRepository, ClientRepository clientRepository) {
        this.serviceRepository = serviceRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/service")
    public String render(Model model) {
        model.addAttribute("service", new Service());
        return "service/form";
    }

    @GetMapping("/service/list")
    public String list(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("services", serviceRepository.findByOwner(user.getId()));
        return "service/list";
    }

    @GetMapping("/service/zmazat")
    public String delete(@RequestParam Long id) {
        clientRepository.deleteByServiceId(id);
        serviceRepository.deleteById(id);
        return "redirect:/service/list";
    }

    @PostMapping("/service")
    public String submit(@ModelAttribute Service service, HttpSession session) {
        User user = (User)session.getAttribute("user");
        service.setOwnerId(user.getId());
        serviceRepository.save(service);
        return "redirect:/service/list";
    }
}
