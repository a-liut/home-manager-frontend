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

    /**
     * Returns all registered devices.
     *
     * @return An array of {@link Device} objects.
     */
    @Override
    public Device[] getAll() {
        return deviceRepository.getAll();
    }

    /**
     * Returns a specific {@link Device} by its ID.
     *
     * @param id The ID of the requested device
     * @return The {@link Device} object.
     */
    @Override
    public Device getById(String id) {
        return deviceRepository.getById(id);
    }

}
