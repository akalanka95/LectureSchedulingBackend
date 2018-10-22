package com.akalanka.backend.services;


public interface AttendanceService {
    void updateMonday(boolean actives);
    void updateTuesday(boolean actives);
    void updateWednesday(boolean actives);
    void updateThursday(boolean actives);
    void updateFriday(boolean actives);


}
