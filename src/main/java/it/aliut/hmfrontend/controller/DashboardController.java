package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.repository.IDeviceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * {@link Controller} for dashboard page.
 */
@Controller
public class DashboardController extends BaseController {

    private final IDeviceRepository deviceRepository;

    public DashboardController(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboard(Model model) {
        Device[] devices = deviceRepository.getAll();

        model.addAttribute("devices", devices);
        model.addAttribute("appTitle", appTitle);

        return "dashboard";
    }
}
