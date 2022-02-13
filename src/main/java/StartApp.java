import java.sql.*;
import java.util.Scanner;

public class StartApp {

    public static void main(String[] args) throws SQLException, NoSuchMethodException {
        BeginApp beginApp = new BeginApp();
        beginApp.begin();
        new AllMethodAtm().mainPage();


    }
}
