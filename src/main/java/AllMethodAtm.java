import java.sql.*;
import java.util.Scanner;
public class AllMethodAtm {

    private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String DB_NAME = "postgres";
    private final static String DB_PASSWORD = "root";
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(DB_URL,DB_NAME,DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    Scanner scanner = new Scanner(System.in);

    public  void  putMoney() throws SQLException {


    }
    public  void withdrawMoney() throws SQLException {

    }
    public  void sendMoney() throws SQLException {

    }
    public void mainPage() throws SQLException {

    }
}
