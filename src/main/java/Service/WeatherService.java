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


    // See meetod peaks lisama weather_data tabelisse internetist saadud ilmainfo, kuid mingil põhjusel ei leia
    public void addToTable(String city, double temperature,
                           double windSpeed, double windDirection) {
        weatherRepository.addWeatherInfo(city, temperature, windSpeed, windDirection);
    }
}
