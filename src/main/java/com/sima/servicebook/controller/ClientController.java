package com.sima.servicebook.controller;


import com.sima.servicebook.model.Client;
import com.sima.servicebook.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("/client")
    public String render(@RequestParam Long serviceId, Model model) {
        Client client = new Client();
        client.setServiceId(serviceId);
        model.addAttribute("client", client);
        return "client/form";
    }

    @GetMapping("/client/list")
    public String list(@RequestParam Long serviceId, Model model) {
        model.addAttribute("clients", clientRepository.findByService(serviceId));
        model.addAttribute("serviceId", serviceId);
        return "client/list";
    }

    @PostMapping("/client")
    public String submit(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/client/list?serviceId="+client.getServiceId();
    }

    @GetMapping("/client/zmazat")
    public String delete(@RequestParam Long serviceId, @RequestParam Long id) {
        clientRepository.deleteById(id);
        return "redirect:/client/list?serviceId"+serviceId;
    }
}


