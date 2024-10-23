package Project;

public class BankAccount {
    public static double accountBalance;
    public static double previousTransaction;
    private String customerName;
    private String customerID;
    private String accountType;

    public BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public String getcustomerName() {
        return customerName;
    }

    public String getcustomerID() {
        return customerID;
    }


}


