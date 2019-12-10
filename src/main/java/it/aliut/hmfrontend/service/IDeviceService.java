package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;

public interface IDeviceService {
    Device[] getAll();

    Device getById(String id);
}
