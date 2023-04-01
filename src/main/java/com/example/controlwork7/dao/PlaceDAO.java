package com.example.controlwork7.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PlaceDAO extends BaseDAO{

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
}
