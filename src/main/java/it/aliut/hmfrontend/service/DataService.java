package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.repository.IDataRepository;
import org.springframework.stereotype.Service;

/**
 * Logic for managing {@link DeviceData} objects.
 */
@Service
public class DataService implements IDataService {

    private final IDataRepository dataRepository;

    public DataService(IDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Returns al registered {@link DeviceData} for a {@link Device}
     *
     * @param device The device to get the data from.
     * @return An array of {@link DeviceData} objects.
     */
    @Override
    public DeviceData[] getForDevice(Device device) {
        return dataRepository.getAllDataForDevice(device);
    }
}
