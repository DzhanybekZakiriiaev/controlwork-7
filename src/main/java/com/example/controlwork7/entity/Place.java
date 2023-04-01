package com.example.controlwork7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Place {
    private Integer placeId;
    private String placeName;
    private String placeDescription;
    private List<Dish> placeDishes;
}
