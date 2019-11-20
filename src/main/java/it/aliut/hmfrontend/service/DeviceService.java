package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
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
}
