package com.example.controlwork7.service;

import com.example.controlwork7.dao.*;
import com.example.controlwork7.entity.Food;
import com.example.controlwork7.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    private FoodDAO foodDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private PlaceDAO placeDAO;
    @Autowired
    private UserDAO userDAO;

    public void createDataBase(){
        userDAO.createTable();
        placeDAO.createTable();
        foodDAO.createTable();
        orderDAO.createTable();
    }
}
