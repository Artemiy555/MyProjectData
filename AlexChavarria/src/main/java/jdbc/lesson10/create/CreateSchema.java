package jdbc.lesson10.create;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreateSchema {

    public static void main(String[] args) {


        String url ="jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "1111";

        try (Connection c = DriverManager.getConnection(url,user,pass)){
            //Класс Statement позволяет нам подготовить и выполнить запрос к базе данных на языке
            Statement statement = c.createStatement();
            statement.executeUpdate("CREATE SCHEMA jdbc");
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
