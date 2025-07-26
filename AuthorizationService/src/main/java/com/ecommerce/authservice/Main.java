package com.ecommerce.authservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");

        String sql = "SELECT * FROM public.employees ORDER BY id ASC ";
        String url = "jdbc:postgresql://localhost:5432/EmployeeDb";
        String username = "postgres";
        String password = "password";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);
    }
}