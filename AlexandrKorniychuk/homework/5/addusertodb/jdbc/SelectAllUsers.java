package jdbc;

import javafx.domian.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectAllUsers {
    private static DataFromDatabase data = new DataFromDatabase();
    private static String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    private static String log = data.getLogin();
    private static String pass = data.getPassword();

    public static Integer getID;

    public static List<User> getUsers() {
        try(Connection c = DriverManager.getConnection(url,log,pass)) {
            Statement statement = c.createStatement();

//            createTable(statement);

            ResultSet set = statement.executeQuery("SELECT * FROM users");

            List<User> users = new ArrayList<>();
            while(set.next()) {
                users.add(new User(getID = set.getInt(1),set.getString(2),set.getString(3)));
            }
            System.out.println(getID);
            statement.close();
            return  users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insertNewUserToDB(int id, String name, String surname) {
        try (Connection con = DriverManager.getConnection(url,log,pass)) {
            PreparedStatement statement = con.prepareStatement(
                            "INSERT INTO users(id, name, surname) VALUES (?, ?, ?)"
                    );

            User person1 = new User(id, name, surname);
            statement.setInt(1, person1.getId());

            System.out.println(person1.getId());
            statement.setString(2, person1.getName());
            statement.setString(3, person1.getSurname());
            statement.execute();

            System.out.println("created user: " + person1);

            statement.clearParameters();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE users(id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(30) NOT NULL, surname VARCHAR (40))"
        );
        statement.close();
    }
}
