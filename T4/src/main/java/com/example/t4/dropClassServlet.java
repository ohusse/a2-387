package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.StudentDAO;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "dropClassServlet", value = "/dropClassServlet")
public class dropClassServlet extends jakarta.servlet.http.HttpServlet {

    private StudentDAO studentDAO;

    public void init() {studentDAO = new StudentDAO();}


    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {

    }

    // dropClass
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        long studentID = (long) session.getAttribute("studentID");

        long courseID = Long.parseLong(request.getParameter("courseID"));
        String courseCode = request.getParameter("courseCode");
        long adminID = Long.parseLong(request.getParameter("adminID"));
        int semesterID = Integer.parseInt(request.getParameter("semesterID"));
        String days = request.getParameter("days");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
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
            studentDAO.dropClass(course, studentID);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("studentServlet");
    }
}
