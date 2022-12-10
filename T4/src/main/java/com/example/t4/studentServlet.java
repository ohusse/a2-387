package com.example.t4;
import com.example.t4.Dao.StudentDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class studentServlet extends jakarta.servlet.http.HttpServlet {

    private StudentDAO studentDAO;

    public void init() {studentDAO = new StudentDAO();}


    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        long studentID = (long) session.getAttribute("studentID");

        try {
            // displayStudentInfo
            ResultSet studentInfoSet = studentDAO.displayStudentInfo(studentID);
            studentInfoSet.next();
            request.setAttribute("studentInfo", studentInfoSet);

            // displayClassesTaken
            ResultSet classesTakenSet = studentDAO.displayClassesTaken(studentID);
            request.setAttribute("classesTaken", classesTakenSet);
            request.setAttribute("studentID",studentID);

            request.getRequestDispatcher("/studentJSP.jsp").forward(request, response);
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
