package com.example.controlwork7.service;

import com.example.controlwork7.dao.PlaceDAO;
import com.example.controlwork7.dto.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

    public List<PlaceDTO> getAllPLaces(){
        return placeDAO.getAllPlaces();
    }
}
