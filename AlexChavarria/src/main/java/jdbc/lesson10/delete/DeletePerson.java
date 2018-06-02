package jdbc.lesson10.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "1111";

    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement statement = c.prepareStatement("DELETE FROM REGISTRATION WHERE ID = ?");
            statement.setInt(1, 201);
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
