package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrieveStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Sowjanya@10";

        String query = "SELECT * FROM students";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records:");
            System.out.println("-----------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                int age = rs.getInt("age");

                System.out.println(
                        id + " | " + name + " | "
                                + course + " | " + age
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}