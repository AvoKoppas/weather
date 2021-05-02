package Service;

import Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void getWeatherInfo(String cityName) {
        weatherRepository.getWeatherInfo(cityName);
    }

    public void addWeatherInfo(double temperature,
                               double windSpeed, String windDirection) {
        weatherRepository.addWeatherData(temperature, windSpeed, windDirection);
    }
}
