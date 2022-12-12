package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Person;

import java.sql.Date;
import java.sql.ResultSet;
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
//        Person person = new Person(10000000,"Jesus", "Christ", "1555 rue Guy", "christtheg@gmail.com",
//                4383376688L, localDate,"lookitsayellowtree");
//        Person person2 = new Person(1,"Santa", "Clause", "1655 rue Guy", "santa@gmail.com",
//                5143376688L, localDate,"lookitsayellowtree");
//        try {
//            ResultSet result = admin.findAdmin(10000000);
//            result.next();
//            System.out.println(result.getString("adminID"));
//            System.out.println(result.getString("firstName"));
//            System.out.println(result.getString("lastName"));
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


        //admin.insertPerson(person);
        //admin.updateAdmin(person);
        //admin.deleteAdmin(100000017);
//

    }


}
