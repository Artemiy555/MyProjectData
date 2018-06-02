package jdbc;


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Locale;

public class CreateTable {

    //Jdbc

    private static String url  =
            "jdbc:mysql://localhost:3306/Jdbc?useSSL=false";
    private static String user = "root";
    private static String pass = "root";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();

            /*CREATE TABLE <Название таблицы>
            *   (<Имя столбца> <Тип данных> <Доп. параметра>*/
            statement.executeUpdate(
                    "CREATE TABLE REGISTRATION" +
                            "(ID INTEGER NOT NULL," +
                            "NAME VARCHAR(30)," +
                            "SURNAME VARCHAR(30)," +
                            "AGE INTEGER," +
                            "PRIMARY KEY (ID))");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
