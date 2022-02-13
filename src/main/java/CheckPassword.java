import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckPassword {

    private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String DB_NAME = "postgres";


    private final static String DB_PASSWORD = "root";
    Connection connection;

    Scanner scanner = new Scanner(System.in);



    {
        try {
            connection = DriverManager.getConnection(DB_URL,DB_NAME,DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkPassword() throws SQLException {


            System.out.println("Введите пароль");

            int passwordCard = scanner.nextInt();


            String query = "select name,password from Customer where password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, passwordCard);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList <Integer> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("Вы зашли в приложение под именем  " + resultSet.getString("name"));
                arrayList.add(resultSet.getInt("password"));
        }

            if (arrayList.isEmpty()) {System.out.println("Вы ввели неверный пароль");
            checkPassword();}


    }
}
