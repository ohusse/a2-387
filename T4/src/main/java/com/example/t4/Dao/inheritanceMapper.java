package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Person;

import java.sql.Date;
import java.time.LocalDate;

public class inheritanceMapper {

    private adminMapper admin;
    private studentMapper student;


    public inheritanceMapper() {
        student = new studentMapper();
        admin = new adminMapper();
    }

    public void execute() throws ClassNotFoundException {

        LocalDate localDate = Date.valueOf("2004-01-10").toLocalDate();
        Person person = new Person(10000019,"Chris", "Columbus", "1222 rue Gilford", "chris.col@yahoo.com",
                4387778888L, localDate,"lookitsayellowtree");
        //admin.insertPerson(person);
        // admin.deleteAdmin(100000017);

        Course courseXd = new Course(1,"COMP222",10000000,2,
                "Mon,Fri","11:00","12:15","Intro to unethical hacking","H420");

    }


}
