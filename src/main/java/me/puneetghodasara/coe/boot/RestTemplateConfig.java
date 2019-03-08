package me.puneetghodasara.coe.boot;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private static final String OWM_BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    @Value("${owm.key}")
    private String API_KEY;

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        if(API_KEY == null){
            throw new BeanCreationException("Open Weather Map API Key is required.");
        }
        return restTemplateBuilder
                .rootUri(OWM_BASE_URL)
                .additionalInterceptors((httpRequest, bytes, clientHttpRequestExecution) -> {
                    httpRequest.getHeaders().add("x-api-key", API_KEY);
                    return clientHttpRequestExecution.execute(httpRequest, bytes);
                })
                .build();
    }

}