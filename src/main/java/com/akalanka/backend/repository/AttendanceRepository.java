package com.akalanka.backend.repository;

import com.akalanka.backend.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRepository extends JpaRepository<Attendance , Integer> {
    @Modifying
    @Query("UPDATE Attendance c SET c.monday = :actives")
    void updateMonday(@Param("actives") boolean actives);

    @Modifying
    @Query("UPDATE Attendance c SET c.tuesday = :actives")
    void updateTuesDay(@Param("actives") boolean actives);

    @Modifying
    @Query("UPDATE Attendance c SET c.wednesday = :actives")
    void updateWednesDay(@Param("actives") boolean actives);

    @Modifying
    @Query("UPDATE Attendance c SET c.thursday = :actives")
    void updateThursDay(@Param("actives") boolean actives);

    @Modifying
    @Query("UPDATE Attendance c SET c.friday = :actives")
    void updateFriday(@Param("actives") boolean actives);
}
