package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.service.IDeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * {@link Controller} for dashboard page.
 */
@Controller
public class DashboardController extends BaseController {

    private final IDeviceService deviceService;

    public DashboardController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboard(Model model) {
        Device[] devices = deviceService.getAll();

        model.addAttribute("devices", devices);
        model.addAttribute("appTitle", appTitle);

        return "dashboard";
    }
}
