package com.example.controlwork7.dto;

import com.example.controlwork7.entity.Food;
import com.example.controlwork7.entity.Place;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private UserDTO client;
    private Food food;
    private Place place;
    private LocalDateTime time;
}
