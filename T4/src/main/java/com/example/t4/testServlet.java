package com.example.t4;
import com.example.t4.Bean.Person;
import com.example.t4.Dao.UniversityDao;
import com.example.t4.Dao.adminMapper;
import com.example.t4.Dao.inheritanceMapper;
import com.example.t4.Dao.studentMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

@WebServlet(name = "testServlet", value = "/testServlet")
public class testServlet extends jakarta.servlet.http.HttpServlet {

    private inheritanceMapper mapper;

    public void init() {
        mapper = new inheritanceMapper();
    }

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        try {

            mapper.execute();
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<p>Query executed. Check database</p>");

            out.println("</body>");
            out.println("</html>");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
