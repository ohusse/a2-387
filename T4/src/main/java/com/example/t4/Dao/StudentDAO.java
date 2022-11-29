package com.example.t4.Dao;
import com.example.t4.Bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class StudentDAO {
    // 1. Display student info
    public ResultSet displayStudentInfo(long studentID) throws SQLException, ClassNotFoundException {
        String queryStudentInfo = "SELECT firstName, lastName, address, email, phoneNum, dob "
                + "FROM student WHERE studentID = " + studentID + ";";
        ResultSet studentInfoSet = null;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStudentInfo);
            studentInfoSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return studentInfoSet;
    }

    // 2. Display list of classes being taken by the student
    // 2.1 Grab course info from course
    // 2.1.1 Grab courseID from classes (nested)
    public ResultSet displayClassesTaken(long studentID) throws SQLException, ClassNotFoundException {
        String nestedGrabCourseIDs = "SELECT courseID FROM classes WHERE studentID = " + studentID;
        String queryEnrolled = "SELECT courseCode, title, days, startTime, endTime, room, courseID, adminID, semesterID "
                + "FROM course WHERE courseID IN (" + nestedGrabCourseIDs + ");";
        ResultSet classesTakenSet = null;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryEnrolled);
            classesTakenSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return classesTakenSet;
    }

    // 3. Drop class (considering date)
    public int dropClass(Course course, long studentID) throws ClassNotFoundException {
        String queryDropClass = "DELETE from classes "
                + "WHERE courseID = ? AND studentID = " + studentID + ";";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(queryDropClass)) {
             preparedStatement.setLong(1, course.getCourseID());

            long courseID = course.getCourseID();

          if(checkDropDate(courseID))
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    // 3.1 Checking drop date
    // 3.1.1 Checking semester endDate
    private boolean checkDropDate(long courseID) throws ClassNotFoundException {
        boolean result = false;
        String nestedGetSemesterID = "SELECT semesterID from course WHERE courseID = " + courseID;
        String queryGetEndDate = "SELECT endDate from semester WHERE semesterID IN (" + nestedGetSemesterID + ");";

        ResultSet resultSet = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryGetEndDate);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String endDateString = String.valueOf(resultSet.getDate("endDate"));
            Date endDate = format.parse(endDateString);
            long endDateMillis = endDate.getTime();
            long currentMillis = System.currentTimeMillis();
            long diffMillis = endDateMillis - currentMillis;
            long diffDays = TimeUnit.MILLISECONDS.toDays(diffMillis);

            if(diffDays >= 0)
                result = true;

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    // 4. View course catalogue of classes NOT being taken by the student
    public ResultSet displayCoursesNotTaken(long studentID) throws ClassNotFoundException {
        String nestedQuery = "SELECT courseID from classes WHERE studentID = " + studentID;
        String queryCoursesNotTaken = "SELECT courseID, courseCode, adminID, semesterID, title, days, startTime, endTime, room "
                + "FROM course WHERE NOT courseID IN (" + nestedQuery + ");";
        ResultSet coursesNotTakenSet = null;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryCoursesNotTaken);
            coursesNotTakenSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return coursesNotTakenSet;
    }

    // 5. Enroll into Class (considering date & limit)
    public int enrollClass(long studentID, Course course) throws ClassNotFoundException {
        String queryEnrollClass = "INSERT INTO classes (studentID, courseID) "
                + "VALUES (" + studentID + ", ?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/university", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(queryEnrollClass)) {
            preparedStatement.setLong(1, course.getCourseID());

            long courseID = course.getCourseID();
            if(checkEnrollDate(courseID) || checkEnrolledFive(studentID))
                result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    // 5.1 Boolean for checking if under 5
    private boolean checkEnrolledFive(long studentID) throws ClassNotFoundException {
        boolean result = false;
        String queryCurrentEnrolled = "SELECT * FROM classes WHERE studentID = " + studentID + ";";

        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryCurrentEnrolled);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            int currentlyTaking = resultSet.getRow();

            if(currentlyTaking < 5)
                result = true;
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    // 5.2 Checking enroll date
    // 5.2.1 Checking semester startDate
    private boolean checkEnrollDate(long courseID) throws ClassNotFoundException {
        boolean result = false;
        String nestedGetSemesterID = "SELECT semesterID from course WHERE courseID = " + courseID;
        String queryGetEndDate = "SELECT startDate from semester WHERE semesterID IN (" + nestedGetSemesterID + ");";

        ResultSet resultSet = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(queryGetEndDate);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = String.valueOf(resultSet.getDate("startDate"));
            Date startDate = format.parse(startDateString);
            long startDateMillis = startDate.getTime();
            long currentMillis = System.currentTimeMillis();
            long diffMillis = currentMillis - startDateMillis;
            long diffDays = TimeUnit.MILLISECONDS.toDays(diffMillis);

            if(diffDays <= 7)
                result = true;

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
