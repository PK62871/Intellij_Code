package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBCTest {
    public static void main(String[] args) {
        try {
            // Correct JDBC URL
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/insert_1", "postgres", "test");

            // Create a statement object
            Statement stmnt = con.createStatement();

            // Execute the query
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM employee");

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                int salary = resultSet.getInt("salary");


                System.out.println("id:"+id + " name:"+name + " email:"+email + " city:"+city+"salary:"+salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


