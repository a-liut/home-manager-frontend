package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.repository.IRepository;

public interface IDeviceService extends IRepository<String, Device> {
    Device[] getAll();

    Device getById(String id);
}
