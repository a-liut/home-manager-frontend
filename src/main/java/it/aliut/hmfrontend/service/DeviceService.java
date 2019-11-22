package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.exception.DeviceNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceService {

    private final RestTemplate restTemplate;

    public DeviceService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Device[] getAllDevices() {
        String url = "http://localhost:8080/devices";
        return restTemplate.getForObject(url, Device[].class);
    }


    public Device getById(String id) {
        String url = "http://localhost:8080/devices/" + id;
        try {
            return restTemplate.getForObject(url, Device.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new DeviceNotFoundException(id);
            }

            throw ex;
        }
    }

    public DeviceData[] getAllDataForDevice(Device device) {
        if (device == null) throw new IllegalArgumentException("Invalid device");

        String url = "http://localhost:8080/devices/" + device.getId() + "/data";

        try {
            return restTemplate.getForObject(url, DeviceData[].class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new DeviceNotFoundException(device.getId());
            }

            throw ex;
        }
    }
}
