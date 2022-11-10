package com.example.t4.Bean;

import java.io.Serializable;
import java.util.Date;

public class Semester implements Serializable {


    private static final long serialVersionUID = 1;

    //  CREATE TABLE `semester` (
    //    `semesterID` int(3) NOT NULL,
    //  `season` varchar(6) NOT NULL,
    //  `year` year(4) NOT NULL,
    //  `startDate` date NOT NULL,
    //    `endDate` date NOT NULL
    //)

    private int semesterID;
    private String season;
    private int year;
    private Date startDate;
    private Date endDate;

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID){
        this.semesterID = semesterID;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season){
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}