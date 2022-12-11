package com.example.t4.Dao;

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

    public void test() throws ClassNotFoundException {
        LocalDate localDate = Date.valueOf("2004-01-10").toLocalDate();
        Person person = new Person(1,"Abraham", "Linclon", "1222 rue Gilford", "abra@yahoo.com",
                4387778888L, localDate,"lookitsayellowtree");
        admin.insertPerson(person);
        //updateStudent(person);
    }


}
