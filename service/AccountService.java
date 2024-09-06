package service;

import entities.Account;

import java.util.Scanner;

public class AccountService {
    public Account accountInput (Scanner scanner) {
        System.out.printf("Nhap Username: ");
        String username = scanner.nextLine();
        System.out.printf("Nhap Password: ");
        String password = scanner.nextLine();
        System.out.printf("Nhap Email: ");
        String Email = scanner.nextLine();

    }
}
