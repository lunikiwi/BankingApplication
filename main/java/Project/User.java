package Project;

import java.util.*;

public class User {
    private String username;
    private String password;
    private BankAccount userBankAccount;
    private static Map<String, User> allUsers = new HashMap<>();

    public User(String username, String password, BankAccount userBankAccount) {
        this.username = username;
        this.password = password;
        this.userBankAccount = userBankAccount;

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Map<String, User> getAllUsers() {
        return allUsers;
    }

    public BankAccount getBankAccount() {
        return userBankAccount;
    }


}
