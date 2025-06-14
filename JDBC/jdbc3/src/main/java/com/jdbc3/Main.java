package com.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Main {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Saikad@1234";
        String query = "delete from table1 where roll_no = 15";
        try{
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement state = conn.createStatement();
            int rowUpdatedNo = state.executeUpdate(query);
            ResultSet rSet2 = state.executeQuery("select * from table1;");
            if(rowUpdatedNo>0){
                System.out.println(rowUpdatedNo+" rows updated successfully");
            }
            while(rSet2.next()){
                System.out.println("=============");
                System.out.println(rSet2.getInt("roll_no"));
                System.out.println(rSet2.getString("name"));
                System.out.println(rSet2.getString("course"));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}