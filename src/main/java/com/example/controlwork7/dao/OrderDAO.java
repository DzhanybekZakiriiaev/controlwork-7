package com.example.controlwork7.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends BaseDAO{

    public OrderDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
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
