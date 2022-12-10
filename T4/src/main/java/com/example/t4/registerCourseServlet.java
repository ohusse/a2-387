package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Random;

@WebServlet(name = "registerCourseServlet", value = "/registerCourseServlet")
public class registerCourseServlet extends jakarta.servlet.http.HttpServlet {

    private UniversityDao admin;

    public void init() {
        admin = new UniversityDao();
    }
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int minNum = 0;
        int maxNum = 100000;
        long random_int = (long)Math.floor(Math.random()*(maxNum-minNum+1)+minNum);

        long courseID = random_int;
        String courseCode = request.getParameter("courseCode");
        long adminID = Long.parseLong(request.getParameter("adminID"));
        int semesterID = Integer.parseInt(request.getParameter("semesterID"));
        String days = request.getParameter("days");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("startTime");
        String title = request.getParameter("title");
        String room = request.getParameter("room");

        Course course = new Course();
        course.setCourseID(courseID);
        course.setCourseCode(courseCode);
        course.setAdminID(adminID);
        course.setSemesterID(semesterID);
        course.setDays(days);
        course.setStartTime(startTime);
        course.setEndTime(endTime);
        course.setTitle(title);
        course.setRoom(room);

        try {
            admin.registerCourse(course);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("adminServlet");
    }
}

//registerCourseServlet