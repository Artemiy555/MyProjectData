package testsql.select;



import testsql.insert.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectAllPerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();
            /* ResultSet - множество записей которые мы получим
            из БД, (не обработанные)*/
            ResultSet set = statement.executeQuery(
                    "SELECT * FROM REGISTRATION"
            );

            List<Person> people = new ArrayList<>();
            while (set.next()) {
                people.add(new Person(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4)
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
