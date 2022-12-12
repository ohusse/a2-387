package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Student;

import java.sql.*;

public class UniversityDao {

    //displays the information of all the courses in the database
    public ResultSet displayAllCourses() throws ClassNotFoundException
    {
        String DISPLAY_ALLCOURSES_SQL = "SELECT DISTINCT c.courseCode, c.title, p.firstName, s.season, c.days, c.startTime, c.endTime,  c.room,  c.courseID "
                + "FROM course AS c "
                + "INNER JOIN person AS p ON c.adminID = p.ID "
                + "INNER JOIN semester AS s ON c.semesterID - s.semesterID "
                + ";";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_ALLCOURSES_SQL);
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //displays the information of a given course
    public ResultSet displayCourseDetails(long courseID) throws ClassNotFoundException
    {
        String DISPLAY_COURSEDETAILS_SQL = "SELECT p.ID, p.firstName, p.lastName "
                + "FROM person AS p "
                + "INNER JOIN classes AS c ON c.studentID = p.ID "
                + "INNER JOIN student AS s ON s.studentID = p.ID "
                + "WHERE c.courseID = " + courseID + ";";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_COURSEDETAILS_SQL );
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //displays the courses a given student is enrolledServlet
    public ResultSet displayStudentCourses(long studentID) throws ClassNotFoundException
    {
        String DISPLAY_STUDENTCOURSES_SQL =
                "SELECT j.courseCode, j.days, j.startTime, j.endTime, j.title, j.room, j.firstName, j.lastName, j.season, j.year "
                        + "(SELECT c.courseCode, c.days, c.startTime, c.endTime, c.title, c.room, p.firstName, p.lastName, s.season, s.year, c.courseID, cl.studentID "
                        + "FROM course AS c "
                        + "INNER JOIN person AS p ON c.adminID = p.ID "
                        + "INNER JOIN semester AS s ON s.semesterID = c.semesterID "
                        + "INNER JOIN classes as cl ON cl.courseID = c.courseID) AS j "
                        + "WHERE j.studentID = " + studentID + ";";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_STUDENTCOURSES_SQL );
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //inserts course into database
    public int registerCourse(Course course) throws ClassNotFoundException {
        String INSERT_COURSE_SQL = "INSERT INTO course" +
                "  (courseID, courseCode, adminID, semesterID, days, startTime, endTime, title, room) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_SQL)) {
            preparedStatement.setLong(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseCode());
            preparedStatement.setLong(3, course.getAdminID());
            preparedStatement.setInt(4, course.getSemesterID());
            preparedStatement.setString(5, course.getDays());
            preparedStatement.setString(6, course.getStartTime());
            preparedStatement.setString(7, course.getEndTime());
            preparedStatement.setString(8, course.getTitle());
            preparedStatement.setString(9, course.getRoom());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    //displays all semesters for drop down menu
    public ResultSet displaySemesters() throws ClassNotFoundException
    {
        String DISPLAY_SEMESTERS_SQL = "SELECT semesterID, season, year FROM semester";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_SEMESTERS_SQL);
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //displays all admins for drop down menu
    public ResultSet displayAdmins() throws ClassNotFoundException
    {
        String DISPLAY_ADMINS_SQL = "SELECT ID, firstName, lastName "
                + "FROM person "
                + "INNER JOIN admin ON admin.adminID = person.ID;";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_ADMINS_SQL);
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //Query for admin verification
    public ResultSet adminVerification(long adminID,String passwords) throws ClassNotFoundException{
        String ADMIN_VERIFICATION_SQL = "SELECT person.ID, person.passwords "
                + "FROM person "
                + "INNER JOIN admin ON admin.adminID = person.ID "
                + "WHERE person.ID = " + adminID + " AND person.passwords = '" + passwords + "';";


        ResultSet result = null;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_VERIFICATION_SQL);
            result = preparedStatement.executeQuery();

        }catch (SQLException e){
            printSQLException(e);
        }
        return result;
    }

    //Query for student verification
    public ResultSet studentVerification(long studentID,String passwords) throws ClassNotFoundException{
        String STUDENT_VERIFICATION_SQL = "SELECT person.ID, person.passwords "
                + "FROM person "
                + "INNER JOIN student ON student.studentID = person.ID "
                + "WHERE person.ID = " + studentID + " AND person.passwords = '" + passwords + "';";
        ResultSet result = null;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(STUDENT_VERIFICATION_SQL);

            result = preparedStatement.executeQuery();

        }catch (SQLException e){
            printSQLException(e);
        }

        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
