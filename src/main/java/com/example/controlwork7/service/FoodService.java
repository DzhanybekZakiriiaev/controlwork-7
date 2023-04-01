package com.example.controlwork7.service;

import com.example.controlwork7.dao.FoodDAO;
import com.example.controlwork7.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodDAO foodDAO;

    public List<Food> getFoodsByPlaceId(Integer placeId){
        return foodDAO.getFoodsByPlaceId(placeId);
    }
}
