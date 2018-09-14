package com.akalanka.backend.services;

import com.akalanka.backend.model.Lecture;
import com.akalanka.backend.model.Semester;

import java.util.List;

public interface LectureService {
    List<Lecture> findAll();
    Lecture save(Lecture lecture);
    List<Lecture> saveAll(List<Lecture> lectures);
    Lecture findById(Integer lecId);
}
