package com.akalanka.backend.repository;

import com.akalanka.backend.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester , Integer> {
}
