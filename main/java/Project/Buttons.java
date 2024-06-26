package Project;
import javax.swing.*;

public class Buttons {


    JButton btnWithdraw = new JButton("Auszahlen");
		btnWithdraw.addActionListener(e -> {
        String WithdrawStr = JOptionPane.showInputDialog(appFrame,
                "Geben Sie den Auszahlungsbetrag ein:" , "Auszahlung", JOptionPane.PLAIN_MESSAGE);
        try {
            double withdrawAmount = Double.parseDouble(WithdrawStr);
            boolean success = TransactionsServices.withdraw(withdrawAmount);
            if (success) {
                JOptionPane.showMessageDialog(appFrame, "Auszahlung von " + withdrawAmount + "€ erfolgreich durchgeführt.");
            } else {
                JOptionPane.showMessageDialog(appFrame, "Nicht genug Geld auf dem Konto", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(appFrame,
                    "Ungültiges Format. Bitte geben Sie eine gültige Zahl ein.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    });
	return btnWithdraw;
}
