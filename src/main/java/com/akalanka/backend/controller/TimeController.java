package com.akalanka.backend.controller;

import com.akalanka.backend.model.Lecture;
import com.akalanka.backend.model.Time;
import com.akalanka.backend.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping("/findAll")
    public List<Time> findAll(){
        return timeService.findAll();
    }

}
