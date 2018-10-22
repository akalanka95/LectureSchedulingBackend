package com.akalanka.backend.repository;

import com.akalanka.backend.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable , Integer>{
    Iterable<TimeTable> findBySemesterId(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :actives WHERE c.date = 1")
    void updateEnableByMonday(@Param("actives") boolean actives);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :actives WHERE c.date = 2")
    void updateEnableByTuesday(@Param("actives") boolean actives);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :actives WHERE c.date = 3")
    void updateEnableByWednesday(@Param("actives") boolean actives);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :actives WHERE c.date = 4")
    void updateEnableByThursday(@Param("actives") boolean actives);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :actives WHERE c.date = 5")
    void updateEnableByFriday(@Param("actives") boolean actives);

    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :active WHERE c.lecture.id = :lecId and c.date = 1")
    void updateWeekByMonday(@Param("lecId") Integer lecId,
                            @Param("active") boolean active);

    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :active WHERE c.lecture.id = :lecId and c.date = 2")
    void updateWeekByTuesday(@Param("lecId") Integer lecId,
                             @Param("active") boolean active);
     @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :active WHERE c.lecture.id = :lecId and c.date = 3")
    void updateWeekByWednesday(@Param("lecId") Integer lecId,
                               @Param("active") boolean active);

    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :active WHERE c.lecture.id = :lecId and c.date = 4")
    void updateWeekByThursday(@Param("lecId") Integer lecId,
                              @Param("active") boolean active);

    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = :active WHERE c.lecture.id = :lecId and c.date = 5")
    void updateWeekByFriday(@Param("lecId") Integer lecId,
                            @Param("active") boolean active);


    /*@Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = true WHERE c.id = :lecId and c.date = 1")
    void updateWeekByMondayTrue(@Param("lecId") Integer lecId );
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = true WHERE c.id = :lecId and c.date = 2")
    void updateWeekByTuesdayTrue(@Param("lecId") Integer lecId);
    *//*@Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = true WHERE c.id = :lecId and c.date = 3")
    void updateWeekByWednesdayTrue(@Param("lecId") Integer lecId);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = true WHERE c.id = :lecId and c.date = 4")
    void updateWeekByThursdayTrue(@Param("lecId") Integer lecId);
    @Modifying
    @Query("UPDATE TimeTable c SET c.tWeek = true WHERE c.id = :lecId and c.date = 5")
    void updateWeekByFridayTrue(@Param("lecId") Integer lecId);

*/

    Iterable<TimeTable> findBySemesterIdAndLectureId(@Param("semId") Integer semId,
                                                     @Param("lecId") Integer lecId);

    Iterable<TimeTable> findBySemesterIdOrLectureId(@Param("semId") Integer semId,
                                                     @Param("lecId") Integer lecId);

    Iterable<TimeTable> findByDateId(@Param("dayId") Integer dayId);

    Iterable<TimeTable> findByLectureId(@Param("lecId") Integer lecId);

            @Modifying
            @Query("SELECT  c FROM TimeTable c WHERE c.tWeek = true")
            Iterable<TimeTable> findByWeek();

}
