package Project;


public class TransactionsServices {

    public static double getBalance(BankAccount account) {
        return account.getAccountBalance();

    }

    public static void deposit(BankAccount account, double amountIn) {
        if(amountIn > 0) {
            double newBalance = account.getAccountBalance() + amountIn;
            account.setAccountBalance(newBalance);
            account.setPreviousTransaction(amountIn);
        }
    }

    public static boolean withdraw(BankAccount account, double amountOut) {
        if (amountOut > account.getAccountBalance()) {
            System.out.println("Account balance too low");
            return false;
        } else {
            account.setAccountBalance(account.getAccountBalance() - amountOut);
            account.setPreviousTransaction(-amountOut);
            return true;
        }
    }

    public static void getPreviousTransaction(BankAccount account) {
        double previousTransaction = account.getPreviousTransaction();

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + -previousTransaction);
        } else {
            System.out.println("No transactions");
        }
    }


}
