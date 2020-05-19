/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.sql.*;

/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public class BooksDBTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/booklib?user=root&password=root");
            Statement stmt = conn.createStatement();
            String query = "SELECT book_id, title FROM books";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id") + " Title: " + rs.getString("title"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
