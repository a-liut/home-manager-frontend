package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.repository.DataRepository;
import it.aliut.hmfrontend.repository.DeviceRepository;
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

    private final DeviceRepository deviceRepository;

    private final DataRepository dataRepository;

    public DeviceController(DeviceRepository deviceRepository, DataRepository dataRepository) {
        this.deviceRepository = deviceRepository;
        this.dataRepository = dataRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String devicesList(Model model) {
        Device[] devices = deviceRepository.getAll();

        model.addAttribute("devices", devices);
        model.addAttribute("appTitle", appTitle);

        return "device/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String device(@PathVariable("id") String id, Model model) {
        Device device = deviceRepository.getById(id);

        DeviceData[] data = dataRepository.getForDevice(device);

        model.addAttribute("device", device);
        model.addAttribute("data", data);
        model.addAttribute("appTitle", appTitle);

        return "device/details";
    }
}
