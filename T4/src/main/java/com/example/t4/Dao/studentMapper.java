package com.example.t4.Dao;

import com.example.t4.Bean.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class studentMapper {

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

    public int updateStudent(Person person){
        String UPDATE_PERSON_SQL = "INSERT INTO person" +
                "  (firstName, lastName, address, email, phoneNum, dob, passwords) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?);";

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
