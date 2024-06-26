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

        /*
        Um die writeUserToFile-Methode mit der aktuellen Definition aufzurufen, müssen Sie einzelne User-Objekte übergeben,
        nicht die gesamte Map. Da getAllUsers eine Map von String zu User zurückgibt, müssen Sie über die Map iterieren und
        jedes User-Objekt einzeln an die writeUserToFile-Methode übergeben.
         */
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

    public static User getAllUsers() {
        return allUsers;
    }

    public BankAccount getBankAccount() {
        return userbankAccount;
    }


}
