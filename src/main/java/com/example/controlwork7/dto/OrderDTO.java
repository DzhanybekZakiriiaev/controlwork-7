package com.example.controlwork7.dto;

import com.example.controlwork7.entity.Food;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private UserDTO client;
    private Food food;
    private PlaceDTO place;
    private LocalDateTime time;
}
