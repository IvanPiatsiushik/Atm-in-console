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

        System.out.println("Положить деньги на счет");
        System.out.println("Введите еще раз пароль");

        int passwordCard = scanner.nextInt();
        System.out.println("Введите сумму");
        int mon = scanner.nextInt();

        String SQL ="update Customer set money = money +'"+mon+"' where password =?";
        PreparedStatement pr = connection.prepareStatement(SQL);
        pr.setInt(1,passwordCard);
        pr.executeUpdate();

        System.out.println("Ваш баланс составляет");
        String SQL2 ="select * from customer where password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL2);
        preparedStatement.setInt(1,passwordCard);
        ResultSet resultSet1 = preparedStatement.executeQuery();

        while (resultSet1.next()){
            System.out.println(resultSet1.getInt("money") );
        }
    }
    public  void withdrawMoney() throws SQLException {

    }
    public  void sendMoney() throws SQLException {

    }
    public void mainPage() throws SQLException {
        System.out.println("Выберите действие");
        System.out.println("1.Положить деньги на счет");
        System.out.println("2.Снять деньги со счета");
        System.out.println("3.Перевести деньги на другой счет");

        Scanner scanner = new Scanner(System.in);
        int meth = scanner.nextInt();

            if (meth == 1) {
               putMoney();
            } else if (meth == 2) {
                withdrawMoney();
            } else if (meth == 3) {
                sendMoney();
            } else {
                System.out.println("Повторите ввод");
                mainPage();
            }
    }
}
