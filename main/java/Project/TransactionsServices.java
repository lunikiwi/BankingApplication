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
            System.out.println("Nicht genug Geld auf dem Konto");
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
            System.out.println("Eingezahlt:" + BankAccount.previousTransaction);
        }
        else if(BankAccount.previousTransaction < 0) {
            System.out.println("Ausgezahlt:" + BankAccount.previousTransaction);
        }
        else {
            System.out.println("Keine Transaktionen");
        }
    }


}
