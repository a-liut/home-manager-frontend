package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.service.IDeviceService;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link DeviceData} objects.
 */
@Repository
public class DataRepository implements IRepository<String, DeviceData> {

    private final IDeviceService deviceService;

    public DataRepository(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public DeviceData[] getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeviceData getById(String id) {
        throw new UnsupportedOperationException();
    }

    public DeviceData[] getForDevice(Device device) {
        return deviceService.getAllDataForDevice(device);
    }
}
