package service;

import model.User;

import java.util.Scanner;

public class UserInput {
    public static User enterDeveloper() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter User's name: ");
                user.setName(scanner.nextLine());
                System.out.println("Enter User's address: ");
                user.setAddress(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid);
        return user;
    }
}
