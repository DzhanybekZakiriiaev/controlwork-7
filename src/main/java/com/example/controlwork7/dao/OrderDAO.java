package com.example.controlwork7.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderDAO extends BaseDAO{

    public OrderDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public String orderFood(Integer place_id, Integer food_id, Long user_id){
        if (isFoodInPlace(place_id,food_id)){
            String sql = "INSERT INTO orders (client_order, food_order, place_order, time_order) " +
                    "VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, user_id, food_id, place_id, LocalDateTime.now());
            return "FOOD IS ORDERED";
        }else {
            return "WE DONT SERVE SUCH FOOD";
        }
    }
    public boolean isFoodInPlace(Integer placeId, Integer foodId) {
        String sql = "SELECT COUNT(*) FROM foods WHERE place_id = ? AND food_id = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{placeId, foodId}, Integer.class);
        return count > 0;
    }
    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS orders(\n" +
                "    order_id SERIAL PRIMARY KEY,\n" +
                "    client_order INTEGER REFERENCES users(id),\n" +
                "    food_order INTEGER REFERENCES foods(food_id),\n" +
                "    place_order INTEGER REFERENCES places(place_id),\n" +
                "    time_order TIMESTAMP NOT NULL\n" +
                "); INSERT INTO orders (client_order, food_order, place_order, time_order) VALUES \n" +
                "(1, 1, 1, '2023-03-29 12:00:00'),\n" +
                "(2, 2, 2, '2023-03-29 13:00:00');");
    }
}
