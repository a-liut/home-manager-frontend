package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.exception.DeviceNotFoundException;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

public class FakeDeviceRepository implements IDeviceRepository {

    private Device[] devices = generateDeviceList();

    private DeviceData[] data = generateDeviceDataList();

    @Override
    public Device[] getAll() {
        return devices;
    }

    @Override
    public Device getById(String id) {
        Device d = findDevice(id);
        if (d == null) throw new DeviceNotFoundException(id + " not found");
        return d;
    }

    private Device findDevice(String id) {
        for (Device d : devices) if (d.getId().equals(id)) return d;
        return null;
    }

    private Device findDevice(Device device) {
        return findDevice(device.getId());
    }

    private Device[] generateDeviceList() {
        return new Device[]{generateDevice("test1", "test1")};
    }

    private Device generateDevice(String id, String name) {
        Device d = new Device();

        d.setId(id);
        d.setName(name);
        d.setAddress("123123");
        d.setHeartbeatUrl("sdajsdia");
        d.setData(Collections.emptyList());
        d.setOnline(false);
        d.setCreatedAt(Instant.now().toString());
        d.setUpdatedAt(Instant.now().toString());

        return d;
    }

    private DeviceData[] generateDeviceDataList() {
        return new DeviceData[]{
                generateDeviceData("test1", "test1", "42"),
                generateDeviceData("test2", "test2", "56")
        };
    }

    private DeviceData generateDeviceData(String id, String name, String value) {
        DeviceData d = new DeviceData();

        d.setId(id);
        d.setName(name);
        d.setUnit("T");
        d.setValue(value);
        d.setCreatedAt(Date.from(Instant.now()));
        d.setUpdatedAt(Date.from(Instant.now()));

        return d;
    }
}
