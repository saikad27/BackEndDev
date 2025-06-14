package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        
        //Database credentials
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Saikad@1234";

        //Establish a connection between database
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement() ){
            System.out.println("Connected to mysql database Successfully");
                
            //Example query
            String query = "Select * from table1";

            /*String query2 = "Insert into table1(roll_no,name,course) values(3,\"Bill\",\"C++\")";
            int count = statement.executeUpdate(query2);
            System.out.println(count);
            */

            ResultSet resultSet = statement.executeQuery(query);
            //Processing the result set
            while(resultSet.next()){
                System.out.print("roll_no: "+resultSet.getInt("roll_no")+" ,");
                System.out.print("name: "+resultSet.getString("name")+" ,");
                System.out.println("course: "+resultSet.getString("course")+" ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}