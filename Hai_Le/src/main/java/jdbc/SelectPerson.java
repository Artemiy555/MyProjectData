package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectPerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        try(Connection connection =
                    DriverManager.getConnection(url, user, pass)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM REGISTRATION");
            List<Person> people = new ArrayList<>();
            while (resultSet.next()) {
                people.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }
            statement.close();
            for (Person p : people) {
                System.out.println("Получена запись: " + p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
