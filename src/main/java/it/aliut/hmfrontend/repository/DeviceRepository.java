package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.service.IDeviceService;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Device} objects.
 */
@Repository
public class DeviceRepository implements IRepository<String, Device> {

    private final IDeviceService deviceService;

    public DeviceRepository(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public Device[] getAll() {
        return deviceService.getAllDevices();
    }

    public Device getById(String id) {
        return deviceService.getById(id);
    }

}
