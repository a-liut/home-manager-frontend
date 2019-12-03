package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.entity.Device;
import it.aliut.hmfrontend.exception.DeviceNotFoundException;
import it.aliut.hmfrontend.repository.DeviceRepository;
import it.aliut.hmfrontend.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceTest {

    @Mock
    RestTemplateBuilder restTemplateBuilder;

    @InjectMocks
    DeviceRepository deviceService;

    private Device[] testDevices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(deviceService, "baseUrl", "http://test:8080");

        RestTemplate rt = mock(RestTemplate.class);
        when(rt.getForObject(any(), any())).thenReturn(testDevices);
        when(restTemplateBuilder.build()).thenReturn(rt);

        testDevices = new Device[]{
                TestUtils.generateDevice("test1", "testName", "address", "heartBeatUrl", Collections.emptyList(), false, "testasd", "test")
        };
    }

    @Test
    public void testGetAllDevices() {
//        when(restTemplate.getForObject(any(), any())).thenReturn(testDevices);

        Device[] devices = deviceService.getAll();

        assertThat(devices).isNotNull()
                .isNotEmpty()
                .isEqualTo(devices);
    }

    @Test
    public void testGetDeviceById() {
        Device testDevice = testDevices[0];

//        when(restTemplate.getForObject(any(), any())).thenReturn(testDevice);

        Device device = deviceService.getById("test");

        assertThat(device).isNotNull()
                .isEqualTo(testDevice);
    }

    @Test(expected = DeviceNotFoundException.class)
    public void testGetDeviceByIdOnNonExistingDevice() {
//        when(restTemplate.getForObject(any(), any())).thenThrow(HttpClientErrorException.class);

        deviceService.getById("test");
    }
}
