package Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WeatherRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addWeatherInfo(String city, double temperature, double windSpeed,
                               double windDirection) {
        String sql = "INSERT INTO weather_data (city, temperature, wind_speed, " +
                "wind_direction) " +
                "VALUES (:city, :temperature, :windSpeed, :windDirection)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", city);
        paramMap.put("temperature", temperature);
        paramMap.put("windSpeed", windSpeed);
        paramMap.put("windDirection", windDirection);
        jdbcTemplate.update(sql, paramMap);
    }
}
