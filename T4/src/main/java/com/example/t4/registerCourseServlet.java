package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "registerCourseServlet", value = "/registerCourseServlet")
public class registerCourseServlet extends javax.servlet.http.HttpServlet {

    private UniversityDao admin;

    public void init() {
        admin = new UniversityDao();
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String courseCode = request.getParameter("courseCode");
        long adminID = Long.parseLong(request.getParameter("adminID"));
        int semesterID = Integer.parseInt(request.getParameter("semesterID"));
        String days = request.getParameter("days");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("startTime");
        String title = request.getParameter("title");
        String room = request.getParameter("room");

        Course course = new Course();
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

        response.sendRedirect("admin.jsp");
    }
}

//registerCourseServlet