package jdbc1; 

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;


public class Main {
    public static void main(String[] args) {
       /*  try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded Successfully");
        }catch(ClassNotFoundException e){

        }*/

        String url = "jdbc:mysql://localhost:3306/student";
        String userName = "root";
        String password = "Saikad@1234";
        String query = "select * from table1;";

        try{
            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection established Successfully");
            Statement statement = connection.createStatement();
            ResultSet rSet = statement.executeQuery(query);
            while(rSet.next()){
                System.out.println("=============");
                System.out.println(rSet.getInt("roll_no"));
                System.out.println(rSet.getString("name"));
                System.out.println(rSet.getString("course"));

            }
          
           

        }catch(SQLException e){
            System.out.println("Exception Occured");
            e.printStackTrace();
        }

    }
}