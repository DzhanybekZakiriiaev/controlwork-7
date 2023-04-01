package com.example.controlwork7.dao;

import com.example.controlwork7.dto.OrderDTO;
import com.example.controlwork7.dto.PlaceDTO;
import com.example.controlwork7.dto.UserDTO;
import com.example.controlwork7.entity.Dish;
import com.example.controlwork7.entity.Food;
import com.example.controlwork7.entity.Place;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<OrderDTO> personalOrders(Long userId) {
        String sql = "SELECT o.time_order, u.*, f.*, p.* FROM orders o " +
                "INNER JOIN users u ON u.id = o.client_order " +
                "INNER JOIN foods f ON f.food_id = o.food_order " +
                "INNER JOIN places p ON p.place_id = o.place_order " +
                "WHERE o.client_order = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, rs -> {
            List<OrderDTO> orders = new ArrayList<>();
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                UserDTO user = new UserDTO();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                order.setClient(user);
                Food food = new Food();
                food.setId(rs.getInt("food_id"));
                food.setDishType(Dish.valueOf(rs.getString("food_type")));
                food.setDishName(rs.getString("food_name"));
                food.setPrice(rs.getInt("food_price"));
                order.setFood(food);
                PlaceDTO place = new PlaceDTO();
                place.setPlaceId(rs.getInt("place_id"));
                place.setPlaceName(rs.getString("place_name"));
                place.setPlaceDescription(rs.getString("place_description"));
                order.setPlace(place);
                order.setTime(rs.getTimestamp("time_order").toLocalDateTime());
                orders.add(order);
            }
            return orders;
        });
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
