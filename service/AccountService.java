package service;

import data.AccountData;
import entities.Account;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountService {

//    Register
    public void accountRegister (Scanner scanner) {
        System.out.printf("Nhap Username: ");
        String username = scanner.nextLine();

        String password = "";
        do {
            System.out.printf("Nhap Password: ");
            String validPassword = scanner.nextLine();
            if(checkValidPassword(validPassword) == null) {
                System.out.println("Password nhap khong hop le (7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt),xin vui long nhap lai");
            }
            else {
                password = validPassword;
                break;
            }
        } while (true);

        String email = "";
        do {
            System.out.printf("Nhap Email: ");
            String validEmail = scanner.nextLine();
            if(checkValidEmail(validEmail) == null) {
                System.out.println("Email nhap khong hop le,xin vui long nhap lai");
            }
            else {
                email = validEmail;
                break;
            }
        } while (true);

        if (checkUsername(username) != null) {
            if (checkEmail(email) != null) {
                System.out.println("Username va Email da duoc su dung, xin vui long nhap Username va Email khac!");
            }
            else {
                System.out.println("Username da duoc su dung, xin vui long nhap Username khac!");
            }
        } else if (checkEmail(email) != null) {
            System.out.println("Email nay da duoc su dung, xin vui long nhap Email khac");
        }
        else {
            System.out.println("Dang ky thanh cong!");
            AccountData.accounts.add(new Account(username, password, email));
        }

        System.out.println(AccountData.accounts);
    }


//    Login
    public Account accountLogin (Scanner scanner) {
//        input
        System.out.printf("Nhap Username: ");
        String username = scanner.nextLine();
        System.out.printf("Nhap Password: ");
        String password = scanner.nextLine();
        Account account = CheckPasswordAndUsername(username, password);

        return account;
    }



//    checkService
    public Account checkUsername (String username) {
        for (Account account: AccountData.accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public Account CheckPasswordAndUsername (String username, String password) {
        int check = 0;
        for (Account account: AccountData.accounts) {
            if (account.getPassword().equals(password) && account.getUsername().equals(username)) {
                System.out.println("Dang nhap thanh cong!");
                return account;
            }
            else if (checkUsername(username) != null) {
                check = 1;
            }
            else {
                check = 2;
            }
        }
        if (check == 1) {
            System.out.println("Password nhap sai");
        }
        else if (check == 2) {
            System.out.println("Username khong ton tai!");
        }
        return null;
    }

    public Account checkEmail (String email) {
        for (Account account: AccountData.accounts) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

//    checkService
    public void usernameUpdate (Account account, Scanner scanner) {
        do {
            System.out.printf("Nhap Username moi: ");
            String username = scanner.nextLine();
            if (checkUsername(username) == null) {
                account.setUsername(username);
                break;
            }
            else {
                System.out.println("Username nay da ton tai, vui long nhap Username khac!");
            }
        } while (true);
    }

    public void emailUpdate (Account account, Scanner scanner) {
        do {
            System.out.printf("Nhap Email moi: ");
            String email = scanner.nextLine();
            if (checkValidEmail(email) == null) {
                if (checkValidEmail(email) == null) {
                    System.out.println("Email nhap khong hop le,xin vui long nhap lai");
                }
                else {
                    account.setEmail(email);
                    break;
                }
            }
            else {
                System.out.println("Email nay da ton tai, vui long nhap Email khac!");
            }
        } while (true);

    }

    public void passwordUpdate (Account account, Scanner scanner) {
        do {
            System.out.printf("Nhap Password moi: ");
            String password = scanner.nextLine();
            if (checkValidPassword(password) == null) {
                System.out.println("Password nhap khong hop le (7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt),xin vui long nhap lai");
            }
            else {
                account.setPassword(password);
                break;
            }
        } while (true);
    }

//    checkValid
public String checkValidEmail (String email) {
        Pattern p =  Pattern.compile("^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$");
        if( p.matcher(email).find()) {
        }
        else {
//            System.out.println("Email nhap khong hop le,xin vui long nhap lai");
            return null;
        }

    return email;
}

    public String checkValidPassword (String password) {
            Pattern p =  Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{7,15}$");
            if( p.matcher(password).find()) {
            }
            else {
//                System.out.println("Password nhap khong hop le (7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt),xin vui long nhap lai");
                return null;
            }

        return password;
    }

}
