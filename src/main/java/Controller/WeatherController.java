package Controller;

import Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    WeatherService weatherService;

    //   http://api.openweathermap.org/data/2.5/weather?q=oslo&units=metric&appid=acd7ef3aa9e680f9efd7c9942797034d
    @GetMapping("http://api.openweathermap.org/data/2.5/weather?&units=metric&" +
            "appid=acd7ef3aa9e680f9efd7c9942797034d")
    public String getWeatherInfo(@RequestParam("q") String q) {
//        weatherService.getWeatherInfo(cityName);
        return "The weather is good";
    }

}
