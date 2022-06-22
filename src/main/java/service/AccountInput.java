package service;

import model.Account;

import java.util.Scanner;

public class AccountInput {
    public static Account enterAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter User's id: ");
                account.setUserID(scanner.nextInt());

                System.out.println("Enter balance account: ");
                account.setBalance(scanner.nextInt());

                System.out.println("Enter currency: ");
                account.setCurrency(scanner.nextLine());
                account.setCurrency(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid);
        return account;
    }




}
