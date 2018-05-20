package testsql.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class InserPerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/test?useSSL=false";
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
                            "INSERT INTO REGISTRATION" +
                                    "(ID, NAME, SURNAME, AGE)" +
                                    "VALUES (?, ?, ?, ?)"
                    );

            Person person1 = new Person(100, "Ivan", "Ivanov", 25);
            statement.setInt(1, person1.getId());
            statement.setString(2, person1.getName());
            statement.setString(3, person1.getSurename());
            statement.setInt(4, person1.getAre());
            statement.execute();

            System.out.println("Создана запись: " + person1);

            statement.clearParameters();

            Person person2 = new Person(200, "Viktor", "Fedorov", 38);
            statement.setInt(1, person2.getId());
            statement.setString(2, person2.getName());
            statement.setString(3, person2.getSurename());
            statement.setInt(4, person2.getAre());
            statement.execute();

            System.out.println("Создана запись: " + person2);

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



