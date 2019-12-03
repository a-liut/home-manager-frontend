package it.aliut.hmfrontend.util;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfiguration
public class ContextConfiguration {
    @Bean
    public RestTemplateBuilder restTemplateBuilder() {

        RestTemplateBuilder rtb = mock(RestTemplateBuilder.class);
        RestTemplate restTemplate = mock(RestTemplate.class);

        when(rtb.build()).thenReturn(restTemplate);
        return rtb;
    }
}
