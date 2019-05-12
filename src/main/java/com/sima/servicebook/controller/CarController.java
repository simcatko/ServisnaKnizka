package com.sima.servicebook.controller;


import com.sima.servicebook.model.Car;
import com.sima.servicebook.repository.CarRepository;
import com.sima.servicebook.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {


    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public CarController (CarRepository carRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }


    @GetMapping("/car")
    public String render( @RequestParam Long clientId, Model model) {
        Car car = new Car();
        car.setClientId(clientId);
        model.addAttribute("car", car);
        model.addAttribute("serviceId", clientRepository.getServiceId(clientId));
        return "car/form";
    }

    @GetMapping("/car/list")
    public String list(@RequestParam Long clientId, Model model) {
        model.addAttribute("clientId", clientId);
        model.addAttribute("serviceId", clientRepository.getServiceId(clientId));
        model.addAttribute("cars", carRepository.findByClient(clientId));
        return "car/list";
    }

    @GetMapping("/car/zmazat")
    public String delete(@RequestParam Long clientId, @RequestParam Long id) {
        carRepository.deleteById(id);
        return "redirect:/car/list?clientId="+clientId;
    }

    @PostMapping("/car")
    public String submit(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/car/list?clientId="+car.getClientId();
    }
}
