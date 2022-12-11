package com.example.t4.Dao;

import com.example.t4.Bean.Course;
import com.example.t4.Bean.Person;
import com.example.t4.Bean.Student;

import java.sql.*;
import java.util.Date;

public class    studentMapper {

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

    public int insertStudent(Person person) throws ClassNotFoundException
    {
        String INSERT_PERSON_SQL = "INSERT INTO person" +
                "  (firstName, lastName, address, email, phoneNum, dob, passwords) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setLong(5, person.getPhoneNum());
            preparedStatement.setObject(6, person.getDob());
            preparedStatement.setString(7, person.getPasswords());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

            String personToStudent =  "INSERT INTO student (studentID) VALUES SELECT MAX(id) FROM person;";
            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_PERSON_SQL);

            result = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    public int updateStudent(Person person) throws ClassNotFoundException {

        String UPDATE_PERSON_SQL = "UPDATE person SET firstName = '"+ person.getFirstName() +"', " +
                "lastName = '" + person.getLastName() + "', " +
                "address = '"+ person.getAddress() +"', " +
                "email = '"+ person.getEmail() +"', " +
                "phoneNum = "+ person.getPhoneNum() +", " +
                "dob = "+ person.getDob() +", " +
                "passwords = '"+ person.getPasswords() +"' " +
                "WHERE ID = "+ person.getID() +";";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SQL)) {

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
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
