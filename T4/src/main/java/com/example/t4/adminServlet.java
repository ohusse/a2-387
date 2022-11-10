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

@WebServlet(name = "adminServlet", value = "/adminServlet")
public class adminServlet extends javax.servlet.http.HttpServlet {
    private UniversityDao admin;

    public void init() {
        admin = new UniversityDao();
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            ResultSet result = admin.displayAdmins();
            result.next();
            String result1 = result.getString(1);
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.print("<p>" + result1 + "</p>");
            out.println("</body></html>");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
