package com.akalanka.backend.controller;

import com.akalanka.backend.model.Lecture;
import com.akalanka.backend.model.Student;
import com.akalanka.backend.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lectures")
public class LectureController {
    @Autowired
    private LectureService lectureService;

    @RequestMapping("/findAll")
    public List<Lecture> findAll(){
        return  lectureService.findAll();
    }

    @PutMapping("/updateAll")
    public List<Lecture> updateAttendance(@RequestBody List<Lecture> lectures){
        return  lectureService.saveAll(lectures);
    }
    @RequestMapping("/addLecture")
    public Lecture saveLecture(@RequestBody Lecture lecture){
        return lectureService.save(lecture);
    }



}
