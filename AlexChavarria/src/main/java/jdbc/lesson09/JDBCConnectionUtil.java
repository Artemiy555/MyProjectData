package jdbc.lesson09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class JDBCConnectionUtil {

    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер обнаружен!");

         //   Locale.setDefault(Locale.ENGLISH);

            String url ="jdbc:mysql://localhost:3306";
            String user = "root";
            String pass = "1111";

            Connection connection = DriverManager.getConnection(url,user,pass);
            if (connection != null){
                System.out.println("Соединение установлено!");
                connection.close();
            }


        }catch (SQLDataException e) {
            System.out.println("Соединение Установлено!");
        }catch (ClassNotFoundException e) {
            System.out.println("Драйвер не обнаружен!");
        }
    }
}
