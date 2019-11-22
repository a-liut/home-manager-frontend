package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.service.DeviceService;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceRepository implements IRepository<String, Device> {

    private final DeviceService deviceService;

    public DeviceRepository(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public Device[] getAll() {
        return deviceService.getAllDevices();
    }

    public Device getById(String id) {
        return deviceService.getById(id);
    }

}
