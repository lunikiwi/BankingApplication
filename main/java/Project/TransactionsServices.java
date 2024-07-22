package Project;

public class TransactionsServices {

    public static double getbalance() {
        return BankAccount.accountBalance;

    }

    static void deposit(double amountIn) {
        if(amountIn > 0) {
            BankAccount.accountBalance = BankAccount.accountBalance + amountIn;
            BankAccount.previousTransaction = amountIn;
        }
    }

    static boolean withdraw(double amountOut) {
        if(amountOut > BankAccount.accountBalance) {
            System.out.println("Account balance too low");
            return false;
        }
        else {
            BankAccount.accountBalance = BankAccount.accountBalance - amountOut;
            BankAccount.previousTransaction = - amountOut;
            return true;
        }
    }

    void getPreviousTransaction() {

        if(BankAccount.previousTransaction > 0) {
            System.out.println("Deposited:" + BankAccount.previousTransaction);
        }
        else if(BankAccount.previousTransaction < 0) {
            System.out.println("Withdrew:" + BankAccount.previousTransaction);
        }
        else {
            System.out.println("No transactions");
        }
    }


}
