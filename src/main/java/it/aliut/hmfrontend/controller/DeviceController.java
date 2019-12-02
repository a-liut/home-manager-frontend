package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.service.IDataService;
import it.aliut.hmfrontend.service.IDeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * {@link Controller} for exposing information about devices.
 */
@Controller
@RequestMapping("/devices")
public class DeviceController extends BaseController {

    private final IDeviceService deviceService;

    private final IDataService dataService;

    public DeviceController(IDeviceService deviceService, IDataService dataService) {
        this.deviceService = deviceService;
        this.dataService = dataService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String devicesList(Model model) {
        Device[] devices = deviceService.getAll();

        model.addAttribute("devices", devices);
        model.addAttribute("appTitle", appTitle);

        return "device/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String device(@PathVariable("id") String id, Model model) {
        Device device = deviceService.getById(id);

        DeviceData[] data = dataService.getForDevice(device);

        model.addAttribute("device", device);
        model.addAttribute("data", data);
        model.addAttribute("appTitle", appTitle);

        return "device/details";
    }
}
