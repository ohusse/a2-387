package com.example.t4;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "createCourseServlet", value = "/createCourseServlet")
public class createCourseServlet extends jakarta.servlet.http.HttpServlet {

    private UniversityDao admin;

    public void init() {
        admin = new UniversityDao();
    }
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        try
        {
            ResultSet result = admin.displayAdmins();
            request.setAttribute("resultString",result);

            ResultSet result2 = admin.displaySemesters();
            request.setAttribute("resultString2",result2);

            request.getRequestDispatcher("/createCourse.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("createCourse.jsp");
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
