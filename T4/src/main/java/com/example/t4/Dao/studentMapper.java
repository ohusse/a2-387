package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Person;
import com.example.t4.Bean.Student;

import java.sql.*;
import java.text.SimpleDateFormat;

public class studentMapper {

    public ResultSet findStudent(long id) throws ClassNotFoundException {
        String FIND_STUDENT = "SELECT studentID, firstName, lastName FROM student, person WHERE studentID =" + id +" AND studentID = ID;";

        ResultSet result = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT);
            result = preparedStatement.executeQuery();

        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }

        return result;
    }

    public int insertPerson(Person person) throws ClassNotFoundException
    {
        String INSERT_PERSON_SQL = "INSERT INTO person" +
                "  (firstName, lastName, address, email, phoneNum, dob, passwords) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?);";
        java.sql.Date sqlDate = java.sql.Date.valueOf(person.getDob() );
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setLong(5, person.getPhoneNum());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, person.getPasswords());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

            this.insertStudent();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    public int insertStudent() throws ClassNotFoundException {


        String INSERT_STUDENT_SQL =  "INSERT INTO student (studentID) SELECT MAX(id) FROM person;";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }


    public int updateStudent(Person person) throws ClassNotFoundException {

        java.sql.Date sqlDate = java.sql.Date.valueOf(person.getDob() );

        String UPDATE_PERSON_SQL = "UPDATE person SET firstName = '"+ person.getFirstName() +"', " +
                "lastName = '" + person.getLastName() + "', " +
                "address = '"+ person.getAddress() +"', " +
                "email = '"+ person.getEmail() +"', " +
                "phoneNum = "+ person.getPhoneNum() +", " +
                "dob = '"+ sqlDate +"', " +
                "passwords = '"+ person.getPasswords() +"' " +
                "WHERE ID = "+ person.getID() +";";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SQL)) {

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    public void deleteStudent(long ID) throws ClassNotFoundException {
        String deleteStudentQuery = "DELETE FROM student WHERE studentID = " + ID +";";

        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university2", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            // process sql exception
            printSQLException(e);
        }
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
