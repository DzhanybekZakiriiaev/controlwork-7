package com.example.controlwork7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Food {
    private Integer id;
    private Dish dishType;
    private String dishName;
    private Integer price;
}
