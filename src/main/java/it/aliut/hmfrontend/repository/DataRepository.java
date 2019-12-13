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
 * Repository for {@link DeviceData} objects.
 */
@Repository
public class DataRepository implements IDataRepository {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public DataRepository(RestTemplateBuilder restTemplateBuilder, @Value("${app.services.devices.url}") String baseUrl) {
        restTemplate = restTemplateBuilder.build();
        this.baseUrl = baseUrl;
    }

    @Override
    public DeviceData[] getAll() {
        URI uri = getUriBuilder()
                .path("/data")
                .build()
                .toUri();

        return restTemplate.getForObject(uri, DeviceData[].class);
    }

    @Override
    public DeviceData getById(String id) {
        URI uri = getUriBuilder()
                .path("/data/{dataId}")
                .buildAndExpand(id)
                .toUri();

        try {
            return restTemplate.getForObject(uri, DeviceData.class);
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
    @Override
    public DeviceData[] getAllDataForDevice(Device device) {
        if (device == null) throw new IllegalArgumentException("Invalid device");

        URI uri = getUriBuilder()
                .path("/data")
                .queryParam("device", device.getId())
                .build()
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
     * Returns a {@link UriComponentsBuilder} initialized with the repository base URL.
     *
     * @return The {@link UriComponentsBuilder} object.
     */
    private UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }
}
