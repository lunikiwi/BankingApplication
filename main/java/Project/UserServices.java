package Project;

import java.io.*;
import java.util.Map;
import java.util.Random;
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



    public static String generateRandomID() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        StringBuilder randomID = new StringBuilder();
        randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
        randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));

        for (int i = 0; i < 4; i++) {
            randomID.append(digits.charAt(new Random().nextInt(digits.length())));

        }

        randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
        randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
        return randomID.toString();
    }






}