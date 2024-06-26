public class TransactionsServices {

    public double getbalance() {
        return BankAccount.accountBalance;

    }

    void deposit(double amountIn) {
        if(amountIn > 0) {
            BankAccount.accountBalance = BankAccount.accountBalance + amountIn;
            BankAccount.previousTransaction = amountIn;
        }
    }

    boolean withdraw(double amountOut) {
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
