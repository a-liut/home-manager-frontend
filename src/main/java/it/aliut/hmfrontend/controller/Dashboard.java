package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.repository.DeviceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dashboard {

    private final DeviceRepository deviceRepository;

    public Dashboard(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @RequestMapping("/")
    public String dashboard(Model model) {

        Device[] devices = deviceRepository.getAll();

        model.addAttribute("devices", devices);

        return "dashboard";
    }
}
