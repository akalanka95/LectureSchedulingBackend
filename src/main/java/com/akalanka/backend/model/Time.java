package com.akalanka.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time")
public class Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY	)
    private Integer id;
    private String Time;

    @OneToMany(mappedBy = "startTime",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JsonIgnore
    private List<TimeTable> startTimeTables;
    @OneToMany(mappedBy = "endTime",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JsonIgnore
    private List<TimeTable> endTimeTables;

    public Time( ) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public List<TimeTable> getStartTimeTables() {
        return startTimeTables;
    }

    public void setStartTimeTables(List<TimeTable> startTimeTables) {
        this.startTimeTables = startTimeTables;
    }

    public List<TimeTable> getEndTimeTables() {
        return endTimeTables;
    }

    public void setEndTimeTables(List<TimeTable> endTimeTables) {
        this.endTimeTables = endTimeTables;
    }
}
