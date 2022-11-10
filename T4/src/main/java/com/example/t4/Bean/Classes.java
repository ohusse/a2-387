package com.example.t4.Bean;

import java.io.Serializable;

public class Classes implements Serializable {
    private long studentID;
    private int courseID;

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}

