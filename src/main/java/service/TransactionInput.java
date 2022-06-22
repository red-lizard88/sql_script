package service;

import model.Account;
import model.Transaction;

import java.util.Scanner;

public class TransactionInput {

    public static Transaction enterTransaction() {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter Account id: ");
                transaction.setAccountId(scanner.nextInt());

                System.out.println("Enter amount: ");
                transaction.setAmount(scanner.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid);
        return transaction;
    }

    public static Transaction enterMinusTransaction() {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter Account id: ");
                transaction.setAccountId(scanner.nextInt());

                System.out.println("Enter amount: ");
                transaction.setAmount(scanner.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid);
        return transaction;
    }
}
