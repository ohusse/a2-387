package com.example.t4.Bean;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable
{
    private long courseID;

    public Course() {
        this.courseID = 0;
        this.courseCode = "";
        this.adminID = 0;
        this.semesterID = 0;
        this.days = "";
        this.startTime = "";
        this.endTime = "";
        this.title = "";
        this.room = "";
    }

    private String courseCode;
    private long adminID;
    private int semesterID;
    private String days;
    private String startTime;
    private String endTime;
    private String title;
    private String room;

    public Course(long courseID, String courseCode, long adminID, int semesterID, String days, String startTime, String endTime, String title, String room) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.adminID = adminID;
        this.semesterID = semesterID;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.room = room;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }


}