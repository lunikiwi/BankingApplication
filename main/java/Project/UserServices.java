package Project;

import java.io.*;
import java.util.Scanner;

public class UserServices{
    public static void loadUserCredentials() {
        File file = new File("C:\\Develop\\Eigenes");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String[] credentials = fileScanner.nextLine().split(";");
                User userloaded = new User(credentials[0], credentials[1], new BankAccount());
                addUser(userloaded);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("User credentials file not found.");
            e.printStackTrace();
        }

    }
    public static void writeUserToFile(User user) {
        String dirName = "C:\\Develop\\Eigenes";
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dirName + "\\userInformation.txt", true));
            fileWriter.write(user.getUsername() + "," + user.getPassword());
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addUser(User usertoadd) {
        User.getAllUsers();
    }
}