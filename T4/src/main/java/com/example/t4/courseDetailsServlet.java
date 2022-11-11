package com.example.t4;
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

@WebServlet(name = "courseDetailsServlet", value = "/courseDetailsServlet")
public class courseDetailsServlet extends javax.servlet.http.HttpServlet {

    private UniversityDao courseDetails;

    public void init() {
        courseDetails = new UniversityDao();
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Long courseID = Long.valueOf(request.getParameter("courseID"));
            ResultSet result = courseDetails.displayCourseDetails(courseID);
            result.next();
            request.setAttribute("resultString",result);
            request.getRequestDispatcher("/courseDetails.jsp").forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
