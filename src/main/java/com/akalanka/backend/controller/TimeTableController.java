package com.akalanka.backend.controller;

import com.akalanka.backend.model.Course;
import com.akalanka.backend.model.Student;
import com.akalanka.backend.model.TimeTable;
import com.akalanka.backend.model.TimeTableWeek;
import com.akalanka.backend.repository.TimeTableRepository;
import com.akalanka.backend.services.CourseService;
import com.akalanka.backend.services.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value =  {"api/timeTables" , "frontend/timeTables"})
public class TimeTableController {
    @Autowired
    private TimeTableService timeTableService;
    @Autowired
    private TimeTableRepository timeTableRepository;

    @RequestMapping("/save")
    public List<TimeTable> save(@RequestBody List<TimeTable> timeTable){
        return  timeTableRepository.save(timeTable);
    }
    @RequestMapping("/findAll")
    public List<TimeTable> findAll(){
        return  timeTableService.findAll();
    }

    @RequestMapping("/addTimeTable")
    public TimeTable addTimeTable(@RequestBody TimeTable timeTable){
        return  timeTableService.save(timeTable);
    }

    @RequestMapping("/findBySemester/{id}")
    public Iterable<TimeTable> findOne(@PathVariable("id") Integer id){
        return  timeTableService.findBySemesterId(id);
    }

    @RequestMapping("/updateEnableByMonday/{active}")
    public void updateMonday(@PathVariable("active") boolean actives){
        System.out.println(" Time Table Comes to the controller");
        timeTableService.updateEnableByMonday(actives);
    }
    @RequestMapping("/updateEnableByTuesday/{active}")
    public void updateTuesday(@PathVariable("active") boolean actives){
        System.out.println(" Time Table Comes to the controller");
        timeTableService.updateEnableByTuesday(actives);
    }
    @RequestMapping("/updateEnableByWednesday/{active}")
    public void updateWednesday(@PathVariable("active") boolean actives){
        System.out.println(" Time Table Comes to the controller");
        timeTableService.updateEnableByWednesday(actives);
    }
    @RequestMapping("/updateEnableByThursday/{active}")
    public void updateThursday(@PathVariable("active") boolean actives){
        System.out.println(" Time Table Comes to the controller");
        timeTableService.updateEnableByThursday(actives);
    }
    @RequestMapping("/updateEnableByFriday/{active}")
    public void updateFriday(@PathVariable("active") boolean actives){
        System.out.println(" Time Table Comes to the controller");
        timeTableService.updateEnableByFriday(actives);
    }



    @RequestMapping("/listOfTimeTableBySemesterAndLecture/{semId}/{lecId}")
    public Iterable<TimeTable> listOfTimeTableBySemesterAndLecture(
            @PathVariable("semId") Integer semId,
            @PathVariable("lecId") Integer lecId){
        System.out.println("listOfTimeTableBySemesterAndLecture Comes to the controller");
        return timeTableService.findBySemesterIdAndLectureId(semId , lecId);
    }

    @RequestMapping("/listOfTimeTableBySemesterORLecture/{semId}/{lecId}")
    public Iterable<TimeTable> listOfTimeTableBySemesterORLecture(
            @PathVariable("semId") Integer semId,
            @PathVariable("lecId") Integer lecId){
        System.out.println("listOfTimeTableBySemesterORLecture Comes to the controller");
        return timeTableService.findBySemesterIdORLectureId(semId , lecId);
    }

    @RequestMapping("/listOfTimeTableByDay/{day}")
    public Iterable<TimeTable> listOfTimeTableByDay(
            @PathVariable("day") Integer day ){
        System.out.println("listOfTimeTableByDay Day day day");
        return timeTableService.findByDateId(day);
    }

    @RequestMapping("/listOfTimeTableByWeek")
    public Iterable<TimeTable> listOfTimeTableByDay(){
        System.out.println("listOfTimeTableByWeek Week Week");
        return timeTableService.findByWeek();
    }

    @RequestMapping("/listOfTimeTableByLectureId/{lecId}")
    public Iterable<TimeTable> listOfTimeTableByLectureId( @PathVariable("lecId") Integer lecId ){
        System.out.println("listOfTimeTableByLectureId lecture Id");
        return timeTableService.findByLectureId(lecId);
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody TimeTable timeTable){
        timeTableService.delete(timeTable);
    }

    @PutMapping("/updateSubject")
    public TimeTable updateStudent(@RequestBody TimeTable timeTable){
        return  timeTableService.save(timeTable);
    }

    /*@RequestMapping("/updateTimeTableAttendance/{lecId}/{dayId}")
    public void updateTimeTableAttendance( @PathVariable("lecId") Integer lecId ,
                                           @PathVariable("dayId") Integer dayId){
        System.out.println("Update time table attendance");
        timeTableService.updateIdByDay(lecId , dayId);
    }*/
    @RequestMapping("/updateTimeTableMondayAttendance/{lecId}/{active}")
    public void updateTimeTableMondayAttendance( @PathVariable("lecId") Integer lecId,
                                                 @PathVariable("active") boolean active){
        System.out.println("Update time table Monday attendance");
        timeTableService.updateIdByMonDay(lecId , active);
    }
    @RequestMapping("/updateTimeTableTuesdayAttendance/{lecId}/{active}")
    public void updateTimeTableTuesdayAttendance( @PathVariable("lecId") Integer lecId,
                                                 @PathVariable("active") boolean active ){
        System.out.println("Update time table  tuesday attendance");
        timeTableService.updateIdByTuesDay(lecId , active);
    }
    @RequestMapping("/updateTimeTableWednesdayAttendance/{lecId}/{active}")
    public void updateTimeTableWednesdayAttendance( @PathVariable("lecId") Integer lecId,
                                                  @PathVariable("active") boolean active ){
        System.out.println("Update time table  wednesday attendance");
        timeTableService.updateIdByWednesDay(lecId , active);
    }
    @RequestMapping("/updateTimeTableThursdayAttendance/{lecId}/{active}")
    public void updateTimeTableThursdayAttendance( @PathVariable("lecId") Integer lecId,
                                                  @PathVariable("active") boolean active ){
        System.out.println("Update time table  thursday attendance");
        timeTableService.updateIdByThursDay(lecId , active);
    }
    @RequestMapping("/updateTimeTableFridayAttendance/{lecId}/{active}")
    public void updateTimeTableFridayAttendance( @PathVariable("lecId") Integer lecId,
                                                  @PathVariable("active") boolean active ){
        System.out.println("Update time table friday attendance");
        timeTableService.updateIdByFriDay(lecId , active);
    }
    /*
    @RequestMapping("/updateTimeTableWednesdayAttendance/{lecId}")
    public void updateTimeTableWednesdayAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table Wednesday attendance");
        timeTableService.updateIdByWednesDay(lecId);
    }
    @RequestMapping("/updateTimeTableThursdayAttendance/{lecId}")
    public void updateTimeTableThursdayAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table thursday attendance");
        timeTableService.updateIdByThursDay(lecId);
    }
    @RequestMapping("/updateTimeTableFridayAttendance/{lecId}")
    public void updateTimeTableFridayAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table friday attendance");
        timeTableService.updateIdByFriDay(lecId);
    }
*/
    /*@RequestMapping("/updateTimeTableMondayTrueAttendance/{lecId}")
    public void updateTimeTableMondayTrueAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table M true attendance");
        timeTableService.updateIdByMonDayTrue(lecId);
    }
    @RequestMapping("/updateTimeTableTuesdayTrueAttendance/{lecId}")
    public void updateTimeTableTuesdayTrueAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table Tues True attendance");
        timeTableService.updateIdByTuesDayTrue(lecId);
    }*/
    /*
    @RequestMapping("/updateTimeTableWednesdayTrueAttendance/{lecId}")
    public void updateTimeTableWednesdayTrueAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table Wed True attendance");
        timeTableService.updateIdByWednesDayTrue(lecId);
    }
    @RequestMapping("/updateTimeTableThursdayTrueAttendance/{lecId}")
    public void updateTimeTableThursdayTrueAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table Thurs True attendance");
        timeTableService.updateIdByThursDayTrue(lecId);
    }
    @RequestMapping("/updateTimeTableFridayTrueAttendance/{lecId}")
    public void updateTimeTableFridayTrueAttendance( @PathVariable("lecId") Integer lecId ){
        System.out.println("Update time table Fri True attendance");
        timeTableService.updateIdByFriDayTrue(lecId);
    }
*/
}
