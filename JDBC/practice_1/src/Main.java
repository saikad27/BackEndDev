import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Saikad@1234";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded Successfully");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection established");
            Statement statement = conn.createStatement();
            ResultSet rSet = statement.executeQuery("Select * from table1");
            //int colCount = rSet.getMetaData().getColumnCount();
            while(rSet.next()){
                System.out.println("============");
                System.out.println(rSet.getInt("roll_no"));
                System.out.println(rSet.getString("name"));
                System.out.println(rSet.getString("course"));
            }



        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
}
