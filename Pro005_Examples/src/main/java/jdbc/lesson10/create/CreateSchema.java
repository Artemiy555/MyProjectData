package jdbc.lesson10.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateSchema {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String url  = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "root";
        String pass = "root";

        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            /*Класс Statement позволяент нам подготовить и выполнить
            * запрос к базе данных на языке SQL*/
            Statement statement = c.createStatement();
            /*SCHEMA - представляет из себя отдельную базу
            * данных на MySQL Server*/
            statement.executeUpdate("CREATE SCHEMA Jdbc");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
