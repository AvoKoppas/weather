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

    public String getWeatherInfo(String cityName) {
        String sql = "INSERT INTO weather_data (temperature,wind_speed, wind_direction) " +
                " WHERE city = :name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", cityName);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public void addWeatherData(double temperature, double windSpeed,
                               String windDirection) {
        String sql = "INSERT INTO weather_data (temperature, wind_speed, " +
                "wind_direction) " +
                "VALUES (:temperature, :windSpeed, :windDirection)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("temperature", temperature);
        paramMap.put("windSpeed", windSpeed);
        paramMap.put("windDirection", windDirection);
        jdbcTemplate.update(sql, paramMap);
    }
}
