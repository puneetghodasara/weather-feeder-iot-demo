package me.puneetghodasara.coe.owm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import me.puneetghodasara.coe.weather.api.WeatherService;
import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.owm.model.OWMResponse;

@Component
public class OWMWeatherService implements WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(OWMWeatherService.class);

    @Resource
    private RestTemplate restTemplate;

    @Value("${owm.cityId}")
    private String cityId;

    @Override
    public WeatherResponse getWeather() {
        final Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", cityId);
        uriVariables.put("units", "metric");
        final OWMResponse owmResponse;
        try {
            owmResponse = restTemplate.getForObject("/?id={id}&units={units}", OWMResponse.class, uriVariables);
            if (owmResponse == null) {
                throw new RestClientException("OWM Response is null");
            }
        } catch (RestClientException e) {
            logger.error("(getWeather) Exception while getting coe data {}", e.getMessage());
            return null;
        }
        return owmResponse.toWeatherResponse();
    }
}
