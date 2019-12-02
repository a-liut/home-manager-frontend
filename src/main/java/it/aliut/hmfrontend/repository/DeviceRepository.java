package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.entity.DeviceData;
import it.aliut.hmfrontend.exception.DeviceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Fetches {@link Device} and {@link DeviceData} information.
 */
@Repository
public class DeviceRepository implements IDeviceRepository {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public DeviceRepository(RestTemplateBuilder restTemplateBuilder, @Value("${app.services.devices.url}") String baseUrl) {
        restTemplate = restTemplateBuilder.build();
        this.baseUrl = baseUrl;
    }

    /**
     * Fetches all registered devices.
     *
     * @return An array containing fetched devices.
     */
    @Override
    public Device[] getAll() {
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
    @Override
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
     * Returns a {@link UriComponentsBuilder} initialized with the repository base URL.
     *
     * @return The {@link UriComponentsBuilder} object.
     */
    private UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }
}
