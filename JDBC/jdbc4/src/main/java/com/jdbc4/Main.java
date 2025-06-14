package com.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String query = "update table1 set course = 'Pascal' where name='Bill';";
        try{
            Connection conn = DriverManager.getConnection(url,"root","Saikad@1234");
            Statement statement = conn.createStatement();
            int updateStatus = statement.executeUpdate(query);
            if(updateStatus !=0){
                System.out.println("Update successful");
            }
            ResultSet rset = statement.executeQuery("select * from table1");
            while(rset.next()){
                System.out.println(rset.getInt("roll_no"));
                System.out.println(rset.getString("name"));
                System.out.println(rset.getString("course"));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}