package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Student;

import java.sql.*;

public class UniversityDao {

    //displays the information of all the courses in the database
    public ResultSet displayAllCourses() throws ClassNotFoundException
    {
        String DISPLAY_ALLCOURSES_SQL = "SELECT c.courseID, c.courseCode, c.days, c.startTime, c.endTime, c.title, c.room, a.firstName, a.lastName, s.season, s.year " +
                "FROM course AS c, admin AS a, semester AS s " +
                "WHERE c.adminID = a.adminID AND c.semesterID = s.semesterID";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

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
        String DISPLAY_COURSEDETAILS_SQL =  "SELECT s.studentID, s.firstName, s.lastName " +
                "FROM student AS s, classes AS c " +
                "WHERE s.studentID = c.studentID AND c.courseID = " + courseID +
                " ORDER BY s.lastName";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_COURSEDETAILS_SQL );
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    //displays the courses a given student is enrolled
    public ResultSet displayStudentCourses(long studentID) throws ClassNotFoundException
    {
        String DISPLAY_STUDENTCOURSES_SQL = "SELECT c.courseCode, c.days, c.startTime, c.endTime, c.title, c.room, a.firstName, a.lastName, s.season, s.year " +
                "FROM course AS c, admin AS a, semester AS s, classes AS cl " +
                "WHERE cl.studentID = " + studentID + " AND cl.courseID = c.courseID AND c.adminID = a.adminID AND c.semesterID = s.semesterID";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

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
        String INSERT_COURSE_SQL = "INSERT INTO employee" +
                "  (courseID, courseCode, adminID, semesterID, days, startTime, endTime, title, room) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/university", "root", "");

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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

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
        String DISPLAY_ADMINS_SQL = "SELECT adminID, firstName, lastName FROM admin";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

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
        String ADMIN_VERIFICATION_SQL = "SELECT adminID,passwords " +
                "FROM admin WHERE adminID =" +
                adminID + " AND passwords =" + passwords;
        ResultSet result = null;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_VERIFICATION_SQL);

            result = preparedStatement.executeQuery();

        }catch (SQLException e){
            printSQLException(e);
        }


        return result;
    }

    //Query for student verification
    public ResultSet studentVerification(long studentID,String passwords) throws ClassNotFoundException{
        String STUDENT_VERIFICATION_SQL = "SELECT studentID,passwords " +
                "FROM admin WHERE adminID =" +
                studentID + " AND passwords =" + passwords;
        ResultSet result = null;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(STUDENT_VERIFICATION_SQL);

            result = preparedStatement.executeQuery();

        }catch (SQLException e){
            printSQLException(e);
        }

        return result;
    }

    // PUT SABRINA's PART HERE

    // 1. View student info
    public int getStudentInfo(int studentID) throws SQLException {
        String queryStudentInfo = "SELECT firstName, lastName, address, email, phoneNum, dob "
                + "FROM student WHERE studentID = " + studentID + ";";

        int result = 0;

        return result;
    }

    // 2. View course catalogue
    public int getSemesterCourseCatalogue(int semesterID) throws SQLException {
        String querySemesterCourseCatalogue = "SELECT courseID, courseCode, adminID, days, startHour, startMinute, endHour, endMinute, title, room "
                + "FROM course WHERE semesterID = " + semesterID + ";";

        int result = 0;

        return result;
    }

    // 3. Add course (considering date & limit)
    public int addCourseToStudent(Course course, Student student) throws ClassNotFoundException {
        String queryAddCourseStudent = "INSERT INTO classes "
                + "(studentID, courseID) "
                + "VALUES (?, ?);";


        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("", "", "");
             PreparedStatement preparedStatement1 = connection.prepareStatement(queryAddCourseStudent)) {

            String countCurrentEnrolled = "SELECT * FROM classes WHERE courseID = ? AND studentID = ?;";
            // Need to count current enrolled rows
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(countCurrentEnrolled);
            rs.last();
            int currentlyTaking = rs.getRow();

            long dateNow = System.currentTimeMillis();
            int semesterID = course.getSemesterID();
            // Need query to access semester start date
            String accessStartDate = "SELECT startDate FROM semester WHERE semesterID = " + semesterID + ";";

            preparedStatement1.setLong(1, student.getStudentID());
            preparedStatement1.setLong(2, course.getCourseID());
            System.out.println(preparedStatement1);

            if(currentlyTaking < 5) {
                result = preparedStatement1.executeUpdate();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    // 4. Drop course (considering date)
    public int dropCourse(Course course, Student student) throws ClassNotFoundException {

        String queryDropCourse = "DELETE FROM classes "
                + "WHERE courseID = ? AND studentID = ?;";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("", "", "");
             PreparedStatement preparedStatement1 = connection.prepareStatement(queryDropCourse)) {
            preparedStatement1.setLong(1, course.getCourseID());
            preparedStatement1.setLong(2, student.getStudentID());
            System.out.println(preparedStatement1);
            result = preparedStatement1.executeUpdate();
        } catch (SQLException e) {
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
