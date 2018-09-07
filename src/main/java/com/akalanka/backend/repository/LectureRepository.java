package com.akalanka.backend.repository;


import com.akalanka.backend.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture , Integer> {
}
