package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Food;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodDAO extends BaseDAO{
    public FoodDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS foods (\n" +
                "  food_id SERIAL PRIMARY KEY,\n" +
                "  food_type TEXT NOT NULL,\n" +
                "  food_name TEXT NOT NULL,\n" +
                "  food_price INTEGER NOT NULL,\n" +
                "  place_id INTEGER NOT NULL REFERENCES places(place_id)\n" +
                ");" + "INSERT INTO foods(food_type, food_name, food_price, place_id) VALUES " +
                "('PIZZA', 'Pizza1', 10, 1),\n" +
                "('DESSERT', 'Dessert1', 5, 1),\n" +
                "('HOT_BEVERAGE', 'Tea1', 2, 2),\n" +
                "('COCKTAIL', 'Cocktail1', 8, 3),\n" +
                "('BELTER_FOOD', 'BelterFood1', 15, 2);");

    }

    public List<Food> getFoodsByPlaceId(Integer placeId) {
        String sql = "SELECT * FROM foods WHERE place_id = ?";
        return jdbcTemplate.query(sql, new Object[]{placeId}, new BeanPropertyRowMapper<>(Food.class));
    }


}
