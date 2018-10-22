package com.akalanka.backend.services;

import com.akalanka.backend.model.TimeTable;

import java.util.List;

public interface TimeTableService {
    List<TimeTable> findAll();
    TimeTable save(TimeTable timeTable);
    void delete(TimeTable timeTable);
    Iterable<TimeTable>  findBySemesterId(Integer semesterID);
    void updateEnableByMonday(boolean actives);
    void updateEnableByTuesday(boolean actives);
    void updateEnableByWednesday(boolean actives);
    void updateEnableByThursday(boolean actives);
    void updateEnableByFriday(boolean actives);


    void updateIdByMonDay(Integer lecId , boolean active);
    void updateIdByTuesDay(Integer lecId, boolean active);
    void updateIdByWednesDay(Integer lecId, boolean active);
    void updateIdByThursDay(Integer lecId, boolean active);
    void updateIdByFriDay(Integer lecId, boolean active);

    /*void updateIdByMonDayTrue(Integer lecId);
    void updateIdByTuesDayTrue(Integer lecId);*/
    /*void updateIdByWednesDayTrue(Integer lecId);
    void updateIdByThursDayTrue(Integer lecId);
    void updateIdByFriDayTrue(Integer lecId);*/
    Iterable<TimeTable>  findBySemesterIdAndLectureId(Integer semId , Integer lecId);
    Iterable<TimeTable>  findBySemesterIdORLectureId(Integer semId , Integer lecId);
    Iterable<TimeTable>  findByDateId(Integer dayId);
    Iterable<TimeTable>  findByWeek();
    Iterable<TimeTable>  findByLectureId(Integer lecId);


}
