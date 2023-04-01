package com.example.controlwork7.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlaceDTO {
    private Integer placeId;
    private String placeName;
    private String placeDescription;
}
