package com.sima.servicebook.controller;


import com.sima.servicebook.enums.RecordTypes;
import com.sima.servicebook.model.Record;
import com.sima.servicebook.repository.CarRepository;
import com.sima.servicebook.repository.ClientRepository;
import com.sima.servicebook.repository.RecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordController {

    private final RecordRepository recordRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    public RecordController(RecordRepository recordRepository, ClientRepository clientRepository, CarRepository carRepository) {
        this.recordRepository = recordRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/record")
    public String render(@RequestParam Long carId, Model model) {
        Record record = new Record();
        Long clientId = carRepository.getClientId(carId);
        record.setCarId(carId);
        model.addAttribute("record", record);
        model.addAttribute("clientId", clientId);
        model.addAttribute("serviceId", clientRepository.getServiceId(clientId));
        model.addAttribute("types", RecordTypes.values());
        return "record/form";
    }

    @GetMapping("/record/list")
    public String list(@RequestParam Long carId, Model model) {
        Long clientId = carRepository.getClientId(carId);
        model.addAttribute("carId", carId);
        model.addAttribute("clientId", clientId);
        model.addAttribute("serviceId", clientRepository.getServiceId(clientId));
        model.addAttribute("typeMenoMap", RecordTypes.getNumberMenoMap());
        model.addAttribute("records", recordRepository.findByCar(carId));
        return "record/list";
    }

    @GetMapping("/record/zmazat")
    public String delete(@RequestParam Long carId, @RequestParam Long id) {
        recordRepository.deleteById(id);
        return "redirect:/record/list?carId="+carId;
    }

    @PostMapping("/record")
    public String submit(@ModelAttribute Record record) {
        this.recordRepository.save(record);
        return "redirect:/record/list?carId=" + record.getCarId();
    }
}
