package com.akalanka.backend.repository;

import com.akalanka.backend.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Integer> {
}
