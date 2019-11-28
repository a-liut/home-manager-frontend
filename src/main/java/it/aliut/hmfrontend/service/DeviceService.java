package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.exception.DeviceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Fetches {@link Device} and {@link DeviceData} information.
 */
@Service
public class DeviceService implements IDeviceService {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public DeviceService(RestTemplateBuilder restTemplateBuilder, @Value("${app.services.devices.url}") String baseUrl) {
        restTemplate = restTemplateBuilder.build();
        this.baseUrl = baseUrl;
    }

    /**
     * Fetches all registered devices.
     *
     * @return An array containing fetched devices.
     */
    public Device[] getAllDevices() {
        URI uri = getUriBuilder()
                .path("/devices")
                .build()
                .toUri();

        return restTemplate.getForObject(uri, Device[].class);
    }


    /**
     * Fetches a single {@link Device} by its ID.
     *
     * @param id The id to be used.
     * @return The {@link Device} object.
     */
    public Device getById(String id) {
        URI uri = getUriBuilder()
                .path("/devices/{deviceId}")
                .buildAndExpand(id)
                .toUri();

        try {
            return restTemplate.getForObject(uri, Device.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new DeviceNotFoundException(id);
            }

            throw ex;
        }
    }

    /**
     * Fetches all {@link DeviceData} publisher by the device.
     *
     * @param device The {@link Device} considered.
     * @return An array containing {@link DeviceData} objects.
     */
    public DeviceData[] getAllDataForDevice(Device device) {
        if (device == null) throw new IllegalArgumentException("Invalid device");

        UriComponentsBuilder builder = getUriBuilder()
                .path("/devices/{deviceId}/data");

        URI uri = builder.buildAndExpand(device.getId())
                .toUri();

        try {
            return restTemplate.getForObject(uri, DeviceData[].class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new DeviceNotFoundException(device.getId());
            }

            throw ex;
        }
    }

    /**
     * Returns a {@link UriComponentsBuilder} initialized with the service base URL.
     *
     * @return The {@link UriComponentsBuilder} object.
     */
    private UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }
}
