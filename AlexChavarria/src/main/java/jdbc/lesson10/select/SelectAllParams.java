package jdbc.lesson10.select;

import jdbc.lesson10.insert.Person;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectAllParams {
    private static String url  =
            "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "1111";

    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection(url,user,pass)) {
            Statement statement = c.createStatement();

            ResultSet set = statement.executeQuery(
                    "SELECT * FROM REGISTRATION"
            );
            List<Person> people = new ArrayList<>();
        while (set.next()){
            people.add(new Person(
                    set.getInt(1),
                    set.getString(2),
                    set.getString(3),
                    set.getInt(4)
            ));
        }
        statement.close();

        for (Person p : people){
            System.out.println("Получена запись "+p);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
