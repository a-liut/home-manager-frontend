package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.service.DeviceService;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository implements IRepository<String, DeviceData> {

    private final DeviceService deviceService;

    public DataRepository(DeviceService deviceService) {
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
