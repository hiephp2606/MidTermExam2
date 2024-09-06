package view;

import entities.Account;
import service.AccountService;

import java.util.Scanner;

public class Menu {
    AccountService accountService = new AccountService();
    public void startMenuDisplay (Scanner scanner) {
        do {
            System.out.println("============Techmaster_start============");
            System.out.println("    1. Dang nhap");
            System.out.println("    2. Dang ky\n");
            System.out.print("Lua chon (1 hoac 2): ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account account = accountService.accountLogin(scanner);
                    if (account != null ) {
                        System.out.println("============WELCOME " + account.getUsername() + "============" );
                        afterLoginMenu(scanner, account);
                    }
                    break;
                case 2:
                    accountService.accountRegister(scanner);
                    break;
            }
        } while (true);
    }

    public void afterLoginMenu (Scanner scanner, Account account) {
        boolean loop =true;
        do {
            System.out.println("   1 - Thay đổi username\n" +
                    "   2 - Thay đổi mật khẩu\n" +
                    "   3 - Thay đổi email\n" +
                    "   4 - Đăng xuất ");

            System.out.printf("Xin vui long nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    accountService.usernameUpdate(account,scanner);
                    break;
                case 2:
                    accountService.passwordUpdate(account,scanner);
                    break;
                case 3:
                    accountService.emailUpdate(account,scanner);
                    break;
                case 4:
                    loop = false;
                    break;
            }
        } while (loop == true);
    }
}

