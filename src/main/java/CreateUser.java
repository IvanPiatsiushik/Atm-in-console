import java.sql.*;
import java.util.Scanner;

public class CreateUser {


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
    public  void createAccount() throws SQLException {
        System.out.println("Пройдите процесс регистрации ");
        String query = "insert into Customer (name, password, numberCard, money) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        System.out.println("Введите ваше имя");
        String name = scanner.nextLine();
        System.out.println("Введите пароль");
        int password = scanner.nextInt();
        System.out.println("Введите данные карты ");
        String numberCard = scanner.next();
        System.out.println("Введите сумму на карте");
        int money = scanner.nextInt();
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,password);
        preparedStatement.setString(3,numberCard);
        preparedStatement.setInt(4,money);
        preparedStatement.execute();
        System.out.println("Вы зарегистрированы в системе под именем "+name + " ваш пароль "+password);

        new BeginApp().begin();
    }
}
