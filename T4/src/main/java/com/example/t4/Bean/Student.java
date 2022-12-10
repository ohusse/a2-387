package com.example.t4.Bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Student extends Person implements Serializable {
    public Student(long ID, String firstName, String lastName, String address, String email, long phoneNum, LocalDate dob, String passwords) {
        super(ID, firstName, lastName, address, email, phoneNum, dob, passwords);
    }
}
