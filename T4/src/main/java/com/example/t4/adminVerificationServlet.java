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

@WebServlet(name = "adminVerificationServlet", value = "/adminVerificationServlet")
public class adminVerificationServlet extends jakarta.servlet.http.HttpServlet {

    private UniversityDao adminVerificaton;
    private inheritanceMapper mapper;
//    private studentMapper student;
//    private adminMapper admin;


    public void init() {
        adminVerificaton = new UniversityDao();
        mapper = new inheritanceMapper();
//        student = new studentMapper();
//        admin = new adminMapper();
    }
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Long adminID = Long.valueOf(request.getParameter("adminID"));
            String password = request.getParameter("password");
            ResultSet result = adminVerificaton.adminVerification(adminID,password);

            mapper.test();
//
//
//
//            LocalDate localDate = Date.valueOf("2004-01-10").toLocalDate();
//
//
//            Person person = new Person(1,"Abraham", "Linclon", "1222 rue Gilford", "abra@yahoo.com",
//                    4387778888L, localDate,"lookitsayellowtree");
//
//            admin.insertPerson(person);
//            //updateStudent(person);

            if(result.next()){
                response.sendRedirect("adminServlet");

            }
            else{
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<body>");
                out.println("<p>Incorrect username or password! Please try again</p>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
