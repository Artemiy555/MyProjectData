package homework.db.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class QETable {

    private static String url = "jdbc:mysql://localhost:3306/QE?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        try (Connection c = DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE QE" +
                    "(NUMBER INTEGER NOT NULL," + "A INTEGER," + "B INTEGER," + "C INTEGER," + "D DOUBLE,"+
                    "RESULT1 DOUBLE,"+"RESULT2 DOUBLE ,"+"PRIMARY KEY (NUMBER))");
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
