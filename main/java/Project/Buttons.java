package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
    public static JButton setupWithdrawButton() {
        //Button für C

        JButton btnWithdraw = new JButton("Auszahlen");
        btnWithdraw.addActionListener(e -> {
            String WithdrawStr = JOptionPane.showInputDialog(ApplicationGUI.getAppFrame(),
                    "Geben Sie den Auszahlungsbetrag ein:", "Auszahlung", JOptionPane.PLAIN_MESSAGE);
            try {
                double withdrawAmount = Double.parseDouble(WithdrawStr);
                boolean success = TransactionsServices.withdraw(withdrawAmount);
                if (success) {
                    JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(), "Auszahlung von " + withdrawAmount + "€ erfolgreich durchgeführt.");
                } else {
                    JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(), "Nicht genug Geld auf dem Konto", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(ApplicationGUI.getAppFrame(),
                        "Ungültiges Format. Bitte geben Sie eine gültige Zahl ein.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        return btnWithdraw;
    }

    private void showExitMessage() {
        JDialog exitDialog = new JDialog(App);
        JLabel exitMessageLabel = new JLabel("Danke, dass Sie unseren Service nutzen", SwingConstants.CENTER);
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

    private JButton setupExitButton() {
        JButton btnExit = new JButton("Beenden");
        btnExit.addActionListener(e -> showExitMessage());
        return btnExit;
    }

}
