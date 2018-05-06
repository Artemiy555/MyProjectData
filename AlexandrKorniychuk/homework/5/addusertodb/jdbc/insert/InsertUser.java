package jdbc.insert;

import javafx.domian.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class InsertUser {

    private static String url  = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        /*PreparedStatement класс который позволяет созтать
        * параметоризированный запрос для работы с БД*/
        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement =
                    c.prepareStatement(
                            "INSERT INTO users(id, name, surname) VALUES (?, ?, ?)"
                    );

            User person1 = new User(1, "Nina", "Petrova");
            statement.setInt(1, person1.getId());
            statement.setString(2, person1.getName());
            statement.setString(3, person1.getSurname());
            statement.execute();

            System.out.println("Создана запись: " + person1);

            statement.clearParameters();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
