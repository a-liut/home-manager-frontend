package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.repository.IDataRepository;
import org.springframework.stereotype.Service;

/**
 * Repository for {@link DeviceData} objects.
 */
@Service
public class DataService implements IDataService {

    private final IDataRepository dataRepository;

    public DataService(IDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public DeviceData[] getForDevice(Device device) {
        return dataRepository.getAllDataForDevice(device);
    }
}
