package com.example.t4;
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

@WebServlet(name = "StudentVerificationServlet", value = "/StudentVerificationServlet")
public class StudentVerificationServlet extends jakarta.servlet.http.HttpServlet {

    private UniversityDao studentVerificaton;

    public void init() {
        studentVerificaton = new UniversityDao();
    }
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            Long studentID = Long.valueOf(request.getParameter("studentID"));
            String password = request.getParameter("password");
            ResultSet result = studentVerificaton.studentVerification(studentID,password);

            session.setAttribute("studentID", studentID);

            if(result.next()){
                response.sendRedirect("studentServlet");
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
