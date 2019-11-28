package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;

public interface IDeviceService {
    Device[] getAllDevices();

    Device getById(String id);

    DeviceData[] getAllDataForDevice(Device device);
}
