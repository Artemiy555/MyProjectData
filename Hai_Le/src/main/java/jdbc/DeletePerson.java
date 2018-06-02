package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class DeletePerson {

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        try(Connection connection =
                    DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM REGISTRATION WHERE ID = ?"
            );
            statement.setInt(1, 100);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
