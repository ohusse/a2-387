package com.example.t4;
import com.example.t4.Bean.Course;
import com.example.t4.Dao.StudentDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "enrolledServlet", value = "/enrolledServlet")
public class enrolledServlet extends javax.servlet.http.HttpServlet {

    private StudentDAO studentDAO;

    public void init() {studentDAO = new StudentDAO();}


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {


    }

    // dropClass
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        long studentID = (long) session.getAttribute("studentID");
        long courseID = Long.parseLong(request.getParameter("courseID"));
        String courseCode = request.getParameter("courseCode");
        long adminID = Long.parseLong(request.getParameter("adminID"));
        int semesterID = Integer.parseInt(request.getParameter("semesterID"));
        String days = request.getParameter("days");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String title = request.getParameter("title");
        String room = request.getParameter("room");

        Course course = new Course();
        course.setCourseID(courseID);
        course.setCourseCode(courseCode);
        course.setAdminID(adminID);
        course.setSemesterID(semesterID);
        course.setDays(days);
        course.setStartTime(startTime);
        course.setEndTime(endTime);
        course.setTitle(title);
        course.setRoom(room);

        try {
            studentDAO.enrollClass(studentID, course);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("studentClassRegistrationServlet");
    }
}
