package com.example.controlwork7.service;

import com.example.controlwork7.dao.OrderDAO;
import com.example.controlwork7.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    public String orderFood(Integer place_id, Integer food_id, Long user_id){
        return orderDAO.orderFood(place_id, food_id, user_id);
    }

    public List<OrderDTO> personalOrders(Long userId){
        return orderDAO.personalOrders(userId);
    }
}
