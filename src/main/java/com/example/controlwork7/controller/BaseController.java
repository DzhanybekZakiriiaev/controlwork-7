package com.example.controlwork7.controller;

import com.example.controlwork7.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/create")
    public void createDataBase(){
        baseService.createDataBase();
    }
}
