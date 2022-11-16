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

@WebServlet(name = "adminVerificationServlet", value = "/adminVerificationServlet")
public class createCourseServlet extends javax.servlet.http.HttpServlet {

    private UniversityDao adminVerificaton;

    public void init() {
        adminVerificaton = new UniversityDao();
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
