package com.akalanka.backend.services.Imp;

import com.akalanka.backend.model.Attendance;
import com.akalanka.backend.repository.AttendanceRepository;
import com.akalanka.backend.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("attendanceService")
public class AttendanceServiceImp implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Override
    @Transactional
    public void updateMonday(boolean actives) {
        System.out.println("This workkkkkkkk");
         attendanceRepository.updateMonday(actives);
    }

    @Override
    @Transactional
    public void updateTuesday(boolean actives) {
        attendanceRepository.updateTuesDay(actives);
    }

    @Override
    @Transactional
    public void updateWednesday(boolean actives) {
        attendanceRepository.updateWednesDay(actives);
    }

    @Override
    @Transactional
    public void updateThursday(boolean actives) {
        attendanceRepository.updateThursDay(actives);
    }

    @Override
    @Transactional
    public void updateFriday(boolean actives) {
        attendanceRepository.updateFriday(actives);
    }
}
