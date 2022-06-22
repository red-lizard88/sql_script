package demo;

import model.Account;
import model.Transaction;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static query.UserQueryExecutor.*;
import static service.TransactionInput.enterMinusTransaction;
import static service.TransactionInput.enterTransaction;
import static service.UserInput.enterDeveloper;
import static service.AccountInput.enterAccount;

public class Main {
    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL =
            //"jdbc:sqlite:c:\\OnDiskD\\Test Automation courses\\HomeTask3 - results\\SqlLiteExample\\developersdb.db";
            "jdbc:sqlite:c:\\Users\\User\\IdeaProjects\\SQLScriptUsers\\UserAccounts.db";


    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            String actionCode;
            do {
                printMenu();
                actionCode = new Scanner(System.in).nextLine();
                switch (actionCode) {
                    case "1":
                        printAllUsers(connection);
                        break;
                    case "2":
                        User user = enterDeveloper();
                        addUser(user, connection);
                        break;
                    case "3":
                        Account account = enterAccount();
                        addAccount(account, connection);
                        break;
                    case "4":
                        Transaction transaction = enterTransaction();
                        addTransaction(transaction, connection);
                        addBalance(transaction, connection);
                        break;
                    case "5":
                        Transaction transaction2 = enterMinusTransaction();
                        addMinusTransaction(transaction2, connection);
                        addBalanceMinus(transaction2, connection);
                        break;
                    case "6":
                        System.out.println("Thanks for using the program!");
                        break;
                    default:
                        System.out.println("Unknown option. Please enter again");
                }

            } while (!"6".equals(actionCode));
            connection.close();
        }
    }

    private static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found");
            return false;
        }
    }

    public static void printMenu() {
        System.out.println("\nВыберите действие");
        System.out.println("1 - Показать пользователей");
        System.out.println("2 - Регистрацию нового пользователя");
        System.out.println("3 - Добавление аккаунта новому пользователю");
        System.out.println("4 - Пополнение существующего аккаунта");
        System.out.println("5 - Снятие средств с существующего аккаунта.");
        System.out.println("6 - quit\n");
    }


}
