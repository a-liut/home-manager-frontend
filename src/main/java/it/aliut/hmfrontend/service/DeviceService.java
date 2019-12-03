package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.repository.IDeviceRepository;
import org.springframework.stereotype.Service;

/**
 * Logic for managing {@link Device} objects.
 */
@Service
public class DeviceService implements IDeviceService {

    private final IDeviceRepository deviceRepository;

    public DeviceService(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device[] getAll() {
        return deviceRepository.getAll();
    }

    @Override
    public Device getById(String id) {
        return deviceRepository.getById(id);
    }

}
