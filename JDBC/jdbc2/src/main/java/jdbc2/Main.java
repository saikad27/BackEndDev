package jdbc2;

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
        String query = "insert into table1(roll_no,name,course) values(101,'James','TypeScript');";
        //Class.getName("com.mysql.jdbc.Driver");
        try{
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement statement = conn.createStatement();
            int status = statement.executeUpdate(query);
            if(status>0){
                System.out.println("Insertion Successful");

                ResultSet rSet = statement.executeQuery("select * from table1");
                while(rSet.next()){
                    System.out.println("=============");
                    System.out.println(rSet.getInt("roll_no"));
                    System.out.println(rSet.getString("name"));
                    System.out.println(rSet.getString("course"));
                }
            }else{
                System.out.println("Insertion failed");
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }

    }
}