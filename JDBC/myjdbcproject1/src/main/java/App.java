import java.sql.*;


public class App {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "Saikad@1234";

        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
            Statement statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO TABLE1 VALUES(5,'Cristopher Duglas','Python')");
            System.out.println("rows affected = "+rowsAffected);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT.TABLE1");
            while(resultSet.next()){
                int rollNo = resultSet.getInt("roll_no");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                System.out.println(rollNo+" "+name+" "+course);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
