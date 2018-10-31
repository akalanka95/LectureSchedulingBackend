package com.akalanka.backend.controller;

import com.akalanka.backend.model.Attendance;
import com.akalanka.backend.model.Day;
import com.akalanka.backend.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/updateMonday/{active}")
    public void updateMonday(@PathVariable("active") boolean actives){
        System.out.println("Comes to the Monday controller");
          attendanceService.updateMonday(actives);
    }
    @RequestMapping("/updateTuesday/{active}")
    public void updateTuesday(@PathVariable("active") boolean actives){
        System.out.println("Comes to the Tuesday controller");
        attendanceService.updateTuesday(actives);
    }
    @RequestMapping("/updateWednesday/{active}")
    public void updateWednesday(@PathVariable("active") boolean actives){
        System.out.println("Comes to the Wenesday controller");
        attendanceService.updateWednesday(actives);
    }
    @RequestMapping("/updateThursday/{active}")
    public void updateThursday(@PathVariable("active") boolean actives){
        System.out.println("Comes to the Thursday controller");
        attendanceService.updateThursday(actives);
    }
    @RequestMapping("/updateFriday/{active}")
    public void updateFriday(@PathVariable("active") boolean actives){
        System.out.println("Comes to the Friday  controller");
        attendanceService.updateFriday(actives);
    }
}
