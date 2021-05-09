package Controller;

import Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    WeatherService weatherService;

    @CrossOrigin
//http://localhost:8080/addToTable/Tartu/1/2/2
    @PostMapping("addToTable/{city}/{temperature}/{windSpeed}/{windDirection}")
    public String addToTable(@PathVariable("city") String city,
                             @PathVariable("temperature") double temperature,
                             @PathVariable("windSpeed") double windSpeed,
                             @PathVariable("windDirection") double windDirection) {
        weatherService.addToTable(city, temperature, windSpeed, windDirection);
        return "Lisatud tabelisse!";
    }

    //   @PostMapping ("deleteWeatherData")
}