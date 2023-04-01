package com.example.controlwork7.controller;

import com.example.controlwork7.dto.PlaceDTO;
import com.example.controlwork7.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/all")
    public List<PlaceDTO> getALLPlaces(){
        return placeService.getAllPLaces();
    }
}
