package Project;
import javax.swing.*;


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
}
