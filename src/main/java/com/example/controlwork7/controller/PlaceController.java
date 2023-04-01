package com.example.controlwork7.controller;

import com.example.controlwork7.entity.Food;
import com.example.controlwork7.entity.Place;
import com.example.controlwork7.service.FoodService;
import com.example.controlwork7.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/all")
    public List<Place> getALLPlaces(){
        return placeService.getAllPLaces();
    }

    @GetMapping("/foods/{id}")
    public List<Food> getALLPlaces(@PathVariable Integer id){
        return foodService.getFoodsByPlaceId(id);
    }
}
