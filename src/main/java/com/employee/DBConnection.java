package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Callable;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String user = "root";
        String password = "Varalakshmi@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args){
        try{
            Connection con = getConnection();
            System.out.println("DB Connected Successfully! Day 3 Rocking!");
            System.out.println("Database: " + con.getCatalog());
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
