package Project;

public class BankAccount {
    private double accountBalance;
    private double previousTransaction;
    private String customerName;
    private String customerID;

    public BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.accountBalance = 0.0;
        this.previousTransaction = 0.0;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setPreviousTransaction(double previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public double getPreviousTransaction() {
        return previousTransaction;
    }

    public String getcustomerName() {
        return customerName;
    }

    public String getcustomerID() {
        return customerID;
    }


}


