package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.StudentDAO;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "studentClassRegistrationServlet", value = "/studentClassRegistrationServlet")
public class studentClassRegistrationServlet extends javax.servlet.http.HttpServlet {

    private StudentDAO studentDAO;

    public void init() {studentDAO = new StudentDAO();}


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        long studentID = (long) session.getAttribute("studentID");

        try {
            // displayCoursesNotTaken
            ResultSet notTakenSet = studentDAO.displayCoursesNotTaken(studentID);
            request.setAttribute("notTaken", notTakenSet);

            request.getRequestDispatcher("/studentEnroll.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // dropClass
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
