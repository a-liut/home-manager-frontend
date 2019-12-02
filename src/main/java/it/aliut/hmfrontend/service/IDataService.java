package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;

public interface IDataService {
    DeviceData[] getForDevice(Device device);
}
