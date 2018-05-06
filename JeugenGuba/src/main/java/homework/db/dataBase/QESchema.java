package homework.db.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class QESchema {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String url  = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "root";
        String pass = "root";

        try (Connection c = DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();
            statement.executeUpdate("CREATE SCHEMA QE");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
