package jdbc.lesson10.update;

import jdbc.lesson10.insert.Person;

import java.sql.*;
import java.util.Locale;

public class UpdatePerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try(Connection c = DriverManager.getConnection(url,user,pass)){

            PreparedStatement statement = c.prepareStatement
                    ("SELECT *FROM REGISTRATION WHERE ID =?");

            statement.setInt(1,200);
            ResultSet set = statement.executeQuery();
            Person person = new Person();

            while (set.next()){
                person.setId(set.getInt(1));
                person.setName(set.getString(2));
                person.setSurname(set.getString(3));
                person.setAge(set.getInt(4));
            }
            statement.close();

            System.out.println("Получена запись:" + person);

            person.setSurname("Petrov");
            person.setAge(47);

            System.out.println("Обновленная запись:"+person);

            PreparedStatement upd = c.prepareStatement("UPDATE REGISTRATION "
            +"SET SURNAME =?, AGE=? WHERE ID=?");
            upd.setString(1,person.getSurname());
            upd.setInt(2,person.getAge());
            upd.setInt(3,person.getId());
            upd.execute();
            upd.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
