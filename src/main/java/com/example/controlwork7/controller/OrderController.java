package com.example.controlwork7.controller;

import com.example.controlwork7.dto.OrderDTO;
import com.example.controlwork7.security.SecurityConfig;
import com.example.controlwork7.service.BaseService;
import com.example.controlwork7.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/{place_id}/{food_id}")
    public String orderFood(@PathVariable Integer place_id, @PathVariable Integer food_id){
        return orderService.orderFood(place_id, food_id, SecurityConfig.getCurrentUserId());
    }

    @GetMapping("/list")
    public List<OrderDTO> personalOrders(){
        return orderService.personalOrders(SecurityConfig.getCurrentUserId());
    }
}
