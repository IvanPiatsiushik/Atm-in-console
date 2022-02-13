import java.sql.SQLException;
import java.util.Scanner;

public class BeginApp {

    Scanner scanner = new Scanner(System.in);
    public void begin() throws SQLException {
        System.out.println("Вас приветствует банк $$$$$$$");
        System.out.println("1.Я клиент банка");
        System.out.println("2.Новый пользователь");

       int numberCommand =  scanner.nextInt();

        while (numberCommand>=3) {
           System.out.println("Некоректный ввод");
           System.out.println("1.Я клиент банка");
           System.out.println("2.Новый пользователь");
            numberCommand =  scanner.nextInt();
       }
        if(numberCommand ==1){
            new CheckPassword().checkPassword();
        }else if(numberCommand==2) new CreateUser().createAccount();
    }


}
