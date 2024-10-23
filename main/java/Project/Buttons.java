package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
    public static JButton setupWithdrawButton() {
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.addActionListener(e -> {
            String WithdrawStr = JOptionPane.showInputDialog(ApplicationGUI.getAppFrame(),
                    "Please enter the amount you want to withdraw:", "Withdraw", JOptionPane.PLAIN_MESSAGE);
            try {
                double withdrawAmount = Double.parseDouble(WithdrawStr);
                boolean success = TransactionsServices.withdraw(withdrawAmount);
                if (success) {
                    JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(), "Withdrawal of " + withdrawAmount + "€ successful.");
                } else {
                    JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(), "Balance is too low ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(),
                        "Invalid Input. Please enter a valid amount ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return btnWithdraw;
    }


    public static JButton setupExitButton() {
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> showExitMessage());
        return btnExit;
    }

    private static void showExitMessage() {
        JDialog exitDialog = new JDialog();
        JLabel exitMessageLabel = new JLabel("Thank you for using our service", SwingConstants.CENTER);
        JPanel testPanel = new JPanel(new BorderLayout());

        testPanel.add(exitMessageLabel, BorderLayout.CENTER);
        exitDialog.setContentPane(testPanel);
        exitDialog.setBounds(500, 150, 300, 200);
        exitDialog.setVisible(true);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitDialog.setVisible(false);
                System.exit(0);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }


    public static JButton setupShowBalanceButton() {
        JButton btnShowBalance = new JButton("Show account balance");
        btnShowBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = TransactionsServices.getbalance();
                JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame() , "The balance is: " + balance + "€");

            }
        });
        return btnShowBalance;
    }

    public static JButton setupDepositButton() {
        //Button für B
        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(e -> {
            String depositStr = JOptionPane.showInputDialog(ApplicationGUI.getAppFrame(),
                    "Please enter the amount you want to deposit:" , "deposit", JOptionPane.PLAIN_MESSAGE);
            try {
                double depositAmount = Double.parseDouble(depositStr);
                TransactionsServices.deposit(depositAmount);
                JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(), "Deposited " + depositAmount + "€ successfully");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(),
                        "Invalid Input. Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return btnDeposit;
    }


}
