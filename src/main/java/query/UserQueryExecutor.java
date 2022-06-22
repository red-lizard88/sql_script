package query;

import model.Account;
import model.Transaction;
import model.User;

import java.sql.*;

import static java.lang.String.format;

public class UserQueryExecutor {

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM Users;";

    public static void printAllUsers(Connection connection) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "userID: " + resultSet.getInt("userID"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("address: " + resultSet.getString("address") + '\n');
        }
        resultSet.close();
        statement.close();
    }

    public static void addUser(User developer, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Users (name, address) VALUES('%s', '%s')",
                developer.getName(), developer.getAddress()));
        statement.close();
    }

    public static void addBalance(Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT balance FROM Accounts WHERE accountId ="+transaction.getAccountId());
        int balance = resultSet.getInt("balance");

        statement.executeUpdate(format("UPDATE Accounts SET balance = '%d' WHERE accountId = %d; ",
                balance+transaction.getAmount(), transaction.getAccountId()));
        statement.close();
    }

    public static void addTransaction(Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                transaction.getAccountId(), transaction.getAmount()));
        statement.close();
    }
    public static void addMinusTransaction(Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                transaction.getAccountId(), -transaction.getAmount()));
        statement.close();
    }

    public static void addBalanceMinus(Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT balance FROM Accounts WHERE accountId ="+transaction.getAccountId());
        int balance = resultSet.getInt("balance");

        statement.executeUpdate(format("UPDATE Accounts SET balance = '%d' WHERE accountId = %d; ",
                balance-transaction.getAmount(), transaction.getAccountId()));
        statement.close();
    }


    public static void addAccount(Account account, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userID, balance, currency) VALUES('%d', '%d', '%s')",
                account.getUserID(), account.getBalance(),account.getCurrency()));
        statement.close();
    }



}
