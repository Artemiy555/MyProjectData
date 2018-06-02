package jdbc.update;

import jdbc.Person;

import java.sql.*;
import java.util.Locale;

public class UpdatePerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        try(Connection connection =
                    DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM REGISTRATION WHERE ID = ?"
            );
            statement.setInt(1, 200);
            ResultSet resultSet = statement.executeQuery();
            Person person = new Person();
            while (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setSurname(resultSet.getString(3));
                person.setId(resultSet.getInt(4));
            }
            statement.close();

            System.out.println("Получена запись: " + person);

            person.setSurname("Петров");
            person.setAge(47);

            System.out.println("Обновленная запись: " + person);


            PreparedStatement update = connection.prepareStatement(
                    "UPDATE REGISTRATION SET SURNAME = ?" +
                            ", AGE = ? WHERE ID = ?");
            update.setString(1, person.getSurname());
            update.setInt(2, person.getAge());
            update.setInt(3, person.getId());
            update.execute();

            update.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
