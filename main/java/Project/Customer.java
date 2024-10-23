package Project;

import java.util.*;

public class Customer {
    private String customername;
    private String password;
    private BankAccount customerBankAccount;
    private static Map<String, Customer> allcustomers = new HashMap<>();

    public Customer(String customer, String password, BankAccount customerBankAccount) {
        this.customername = customer;
        this.password = password;
        this.customerBankAccount = customerBankAccount;
    }

    public String getcustomername() {
        return customername;
    }

    public String getPassword() {
        return password;
    }

    public static Map<String, Customer> getAllcustomers() {
        return allcustomers;
    }

    public BankAccount getBankAccount() {
        return customerBankAccount;
    }


}
