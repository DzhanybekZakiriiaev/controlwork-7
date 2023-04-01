package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Food;
import com.example.controlwork7.entity.Place;
import com.example.controlwork7.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceDAO extends BaseDAO{
    @Autowired
    private FoodService foodService;

    public PlaceDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS places (\n" +
                "  place_id SERIAL PRIMARY KEY,\n" +
                "  place_name TEXT NOT NULL,\n" +
                "  place_description TEXT\n" +
                "); INSERT INTO places (place_name, place_description)\n" +
                "VALUES ('Pizza Palace', 'The best pizza in town'),\n" +
                "       ('Dessert Den', 'Satisfy your sweet tooth'),\n" +
                "       ('Cocktail Cove', 'Creative cocktails and more');");
    }
    public List<Place> getAllPlaces() {
        String sql = "SELECT * FROM places";
        List<Place> places = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Place.class));

        for (Place place : places) {
            List<Food> foods = foodService.getFoodsByPlaceId(place.getPlaceId());
            place.setPlaceFoods(foods);
        }

        return places;
    }

}
