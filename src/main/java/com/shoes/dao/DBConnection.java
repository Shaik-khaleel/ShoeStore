package com.shoes.dao;

import java.sql.*;

public class DBConnection {

    private static String url =
            "jdbc:mysql://localhost:3306/shoestore";

    private static String user = "root";

    private static String password = "Khaleel@2022";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(
              "com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    url,user,password);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}