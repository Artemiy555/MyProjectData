package homework.db.dataBase.insert;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import static java.sql.Types.NULL;

public class InsertRecord {

    public static void insertInDB(int i, int a, int b, int c, int d, double x1, double x2) {
        String url = "jdbc:mysql://localhost:3306/QE?useSSL=false";
        String user = "root";
        String pass = "root";
        Locale.setDefault(Locale.ENGLISH);
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO qe" + "(NUMBER, A, B, C, D, RESULT1, RESULT2)" + "VALUES (?, ?, ?, ?, ?, ?, ?)");

            Record rec = new Record(i, a, b, c, d, x1,x2);
            statement.setInt(1,rec.getNumber());
            statement.setInt(2,rec.getKoefA());
            statement.setInt(3,rec.getKoefB());
            statement.setInt(4,rec.getKoefC());
            statement.setInt(5,rec.getDescr());
            statement.setDouble(6,rec.getX1());
            statement.setDouble(7,rec.getX2());
            statement.execute();
            System.out.println("Create record - " + rec);
            statement.clearParameters();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertInDB(int i, int a, int b, int c, int d, double x1) {
            String url = "jdbc:mysql://localhost:3306/QE?useSSL=false";
            String user = "root";
            String pass = "root";
            Locale.setDefault(Locale.ENGLISH);
            double x2 = x1;
            try (Connection con = DriverManager.getConnection(url, user, pass)) {
                PreparedStatement statement = con.prepareStatement("INSERT INTO qe" + "(NUMBER, A, B, C, D, RESULT1, RESULT2)" + "VALUES (?, ?, ?, ?, ?, ?, ?)");

                Record rec = new Record(i, a, b, c, d, x1,x2);
                statement.setInt(1,rec.getNumber());
                statement.setInt(2,rec.getKoefA());
                statement.setInt(3,rec.getKoefB());
                statement.setInt(4,rec.getKoefC());
                statement.setInt(5,rec.getDescr());
                statement.setDouble(6,rec.getX1());
                statement.setDouble(7,rec.getX2());
                statement.execute();
                System.out.println("Create record - " + rec);
                statement.clearParameters();

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public static void insertInDB(int i, int a, int b, int c, int d) {
        String url = "jdbc:mysql://localhost:3306/QE?useSSL=false";
        String user = "root";
        String pass = "root";
        Locale.setDefault(Locale.ENGLISH);
        double x1 = 0.00;
        double x2 = 0.00;
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO qe" + "(NUMBER, A, B, C, D, RESULT1, RESULT2)" + "VALUES (?, ?, ?, ?, ?, ?, ?)");

            Record rec = new Record(i, a, b, c, d, x1,x2);
            statement.setInt(1,rec.getNumber());
            statement.setInt(2,rec.getKoefA());
            statement.setInt(3,rec.getKoefB());
            statement.setInt(4,rec.getKoefC());
            statement.setInt(5,rec.getDescr());
            statement.setDouble(6,rec.getX1());
            statement.setDouble(7,rec.getX2());
            statement.execute();
            System.out.println("Create record - " + rec );
            statement.clearParameters();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
