package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.User;
import it.aliut.hmfrontend.service.IDeviceService;
import it.aliut.hmfrontend.service.IUserService;
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
    private final IUserService userService;

    public DashboardController(IDeviceService deviceService, IUserService userService) {
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboard(Model model) {
        Device[] devices = deviceService.getAll();
        User[] users = userService.getAll();

        model.addAttribute("devices", devices);
        model.addAttribute("users", users);
        model.addAttribute("appTitle", appTitle);

        return "dashboard";
    }
}
