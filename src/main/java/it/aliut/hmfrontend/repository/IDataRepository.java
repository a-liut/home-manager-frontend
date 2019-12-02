package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;

public interface IDataRepository extends IRepository<String, DeviceData> {
    DeviceData[] getAllDataForDevice(Device device);
}
