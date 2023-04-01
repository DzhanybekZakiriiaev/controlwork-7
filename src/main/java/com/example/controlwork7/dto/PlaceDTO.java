package com.example.controlwork7.dto;
import com.example.controlwork7.entity.Food;
import lombok.Data;

import java.util.List;

@Data
public class PlaceDTO {
    private Integer placeId;
    private String placeName;
    private String placeDescription;
    private List<Food> foods;
}
