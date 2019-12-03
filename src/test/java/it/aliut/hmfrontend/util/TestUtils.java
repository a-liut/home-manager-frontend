package it.aliut.hmfrontend.util;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;

import java.util.Date;
import java.util.List;

public class TestUtils {

    public static Device generateDevice(String id, String name, String address, String heartbeatUrl, List<String> data, boolean online, String createdAt, String updatedAt) {
        Device d = new Device();

        d.setId(id);
        d.setName(name);
        d.setAddress(address);
        d.setHeartbeatUrl(heartbeatUrl);
        d.setData(data);
        d.setOnline(online);
        d.setCreatedAt(createdAt);
        d.setUpdatedAt(updatedAt);

        return d;
    }

    public static DeviceData generateDeviceData(String id, String name, String value, String unit, Date createdAt, Date updatedAt) {
        DeviceData d = new DeviceData();

        d.setId(id);
        d.setName(name);
        d.setUnit(unit);
        d.setValue(value);
        d.setCreatedAt(createdAt);
        d.setUpdatedAt(updatedAt);

        return d;
    }
}
