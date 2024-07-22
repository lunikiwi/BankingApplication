package Project;

import java.util.*;

public class User {
    private String username;
    private String password;
    private BankAccount userbankAccount;
    private static Map<String, User> allUsers = new HashMap<>();

    public User(String username, String password, BankAccount userbankAccount) {
        this.username = username;
        this.password = password;
        this.userbankAccount = userbankAccount;
        UserServices.addUser(this);

        allUsers.put(username, this);

        for (User user : allUsers.values()) {
            UserServices.writeUserToFile(user);
        }
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
        return userbankAccount;
    }


}
