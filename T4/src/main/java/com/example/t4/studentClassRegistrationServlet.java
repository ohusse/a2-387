package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.StudentDAO;
import com.example.t4.Dao.UniversityDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "studentClassRegistrationServlet", value = "/studentClassRegistrationServlet")
public class studentClassRegistrationServlet extends jakarta.servlet.http.HttpServlet {

    private StudentDAO studentDAO;

    public void init() {studentDAO = new StudentDAO();}


    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
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
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
