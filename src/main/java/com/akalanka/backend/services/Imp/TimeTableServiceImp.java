package com.akalanka.backend.services.Imp;

import com.akalanka.backend.model.TimeTable;
import com.akalanka.backend.repository.TimeTableRepository;
import com.akalanka.backend.services.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("timeTableService")
public class TimeTableServiceImp implements TimeTableService {
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Override
    public List<TimeTable> findAll() {
        return timeTableRepository.findAll();
    }

    @Override
    public TimeTable save(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    @Override
    public void delete(TimeTable timeTable) {
        timeTableRepository.delete(timeTable);
    }

    @Override
    public Iterable<TimeTable>  findBySemesterId(Integer semesterID) {
        return  timeTableRepository.findBySemesterId(semesterID);
    }

    @Override
    @Transactional
    public void updateEnableByMonday(boolean actives) {
        System.out.println("Time Table This workkkkkkkk");
        timeTableRepository.updateEnableByMonday(actives);
    }
    @Override
    @Transactional
    public void updateEnableByTuesday(boolean actives) {
        System.out.println("Time Table This workkkkkkkk");
        timeTableRepository.updateEnableByTuesday(actives);
    }@Override
    @Transactional
    public void updateEnableByWednesday(boolean actives) {
        System.out.println("Time Table This workkkkkkkk");
        timeTableRepository.updateEnableByWednesday(actives);
    }
    @Override
    @Transactional
    public void updateEnableByThursday(boolean actives) {
        System.out.println("Time Table This workkkkkkkk");
        timeTableRepository.updateEnableByThursday(actives);
    }@Override
    @Transactional
    public void updateEnableByFriday(boolean actives) {
        System.out.println("Time Table This workkkkkkkk");
        timeTableRepository.updateEnableByFriday(actives);
    }
    @Override
    @Transactional
    public void updateIdByMonDay(Integer lecId , boolean active) {
        timeTableRepository.updateWeekByMonday(lecId , active);
    }
    @Override
    @Transactional
    public void updateIdByTuesDay(Integer lecId , boolean active) {
        System.out.println("In the tuesday false service ");
        timeTableRepository.updateWeekByTuesday(lecId , active);
    }
    @Override
    @Transactional
    public void updateIdByWednesDay(Integer lecId, boolean active) {
        timeTableRepository.updateWeekByWednesday(lecId, active);
    }
    @Override
    @Transactional
    public void updateIdByThursDay(Integer lecId, boolean active) {
        timeTableRepository.updateWeekByThursday(lecId, active);
    }
    @Override
    @Transactional
    public void updateIdByFriDay(Integer lecId, boolean active) {
        timeTableRepository.updateWeekByFriday(lecId, active);
    }

    /*@Override
    @Transactional
    public void updateIdByMonDayTrue(Integer lecId) {
        timeTableRepository.updateWeekByMondayTrue(lecId);
    }
    @Override
    @Transactional
    public void updateIdByTuesDayTrue(Integer lecId) {
        System.out.println("In the tuesday true service ");
        timeTableRepository.updateWeekByTuesdayTrue(lecId);
    }*/
    /* @Override
   @Transactional
   public void updateIdByWednesDayTrue(Integer lecId) {
       timeTableRepository.updateWeekByWednesdayTrue(lecId);
   }
   @Override
   @Transactional
   public void updateIdByThursDayTrue(Integer lecId) {
       timeTableRepository.updateWeekByThursdayTrue(lecId);
   }
   @Override
   @Transactional
   public void updateIdByFriDayTrue(Integer lecId) {
       timeTableRepository.updateWeekByFridayTrue(lecId);
   }

*/
    @Override
    public Iterable<TimeTable> findBySemesterIdAndLectureId(Integer semId, Integer lecId) {
        return timeTableRepository.findBySemesterIdAndLectureId(semId, lecId);
    }
    @Override
    public Iterable<TimeTable> findBySemesterIdORLectureId(Integer semId, Integer lecId) {
        return timeTableRepository.findBySemesterIdOrLectureId(semId, lecId);
    }

    @Override
    public Iterable<TimeTable> findByDateId(Integer dayId) {
        return timeTableRepository.findByDateId(dayId);
    }

    @Override
    public Iterable<TimeTable> findByWeek() {
        return timeTableRepository.findByWeek();
    }

    @Override
    public Iterable<TimeTable> findByLectureId(Integer lecId) {
        return timeTableRepository.findByLectureId(lecId);
    }
}
