package Project;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;



public class CustomerServices{
    public static void loadCustomerCredentials() {
        File file = new File("C:\\Develop\\Eigenes\\customerInformation.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String[] credentials = fileScanner.nextLine().split(";");
                if (credentials.length == 3) {
                    String password = credentials[0];
                    String customerName = credentials[1];
                    String customerID = credentials[2];

                    BankAccount bankAccount = new BankAccount(customerName, customerID);
                    Customer customerLoaded = new Customer(customerName, password, bankAccount);
                    Customer.getAllcustomers().put(customerName, customerLoaded);
                } else {
                    System.err.println("Invalid line format: " + Arrays.toString(credentials));
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean validateLogin(String username, String password) {
        Customer customer = Customer.getAllcustomers().get(username);
        return customer != null && customer.getPassword().equals(password);
    }



    public static void writeCustomerToFile(Customer customer) {
        String dirName = "C:\\Develop\\Eigenes";
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dirName + "\\customerInformation.txt", true));
            fileWriter.write(customer.getcustomername() + "," + customer.getPassword());
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addCustomer(Customer customertoadd) {
        Customer.getAllcustomers();
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