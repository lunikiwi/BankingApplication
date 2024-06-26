package Project;

import javax.swing.*;
//import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.*;

//Login as a Popup for GUI

public class ApplicationGUI {
	private JTextField usernameField;
	private JTextField passwordField;
	private static JFrame appFrame;
	private BankAccount bankAccount01;
	private JLabel nameLabel;
	private JLabel idLabel;
	GridBagLayout gbl = new GridBagLayout();

	//newAccount is the alias for BankAccount, reference to the object, known under this name in the constructor
	//constructor of object ApplicationGUI, defines what happens when an instance is created
	public ApplicationGUI(BankAccount newAccount) {
		//defines the scope in such a way, that newAccount can be used more than in this area, reference/alias
		//otherwise it only reaches after the curly brackets after setupButtons
		this.bankAccount01 = newAccount;
		setupMainFrame();
		setupLabels();
		setupButtons();
	}

	public static JFrame getAppFrame() {
		return appFrame;
	}

	private void setupMainFrame() {
		appFrame = new JFrame("Bankprogramm");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setLayout(new BorderLayout());
	}

	public void LoginWindow() {
		usernameField = new JTextField("Benutzername", 15);
		usernameField.add(usernameField);
		passwordField = new JPasswordField("Passwort", 15);
		usernameField.add(passwordField);

	}

	private void setupLabels() {
		nameLabel = new JLabel("Guten Tag. Sie sind als " + bankAccount01.getcustomerName() +  " angemeldet.");
		idLabel = new JLabel("BenutzerID: " + bankAccount01.getcustomerID());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(idLabel);
		//labelPanel.add(exit)
		appFrame.add(labelPanel, BorderLayout.NORTH);

	}

	private void showExitMessage() {
		JDialog exitDialog = new JDialog(appFrame);
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



	private void setupButtons() {
		JButton btnShowBalance = setupShowBalanceButton();
		JButton btnDeposit = setupDepositButton();
		JButton btnWithdraw = Buttons.setupWithdrawButton();
		JButton btnExit = setupExitButton();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		buttonPanel.add(btnShowBalance, gbc);

		gbc.gridy = 1;
		buttonPanel.add(btnDeposit, gbc);

		gbc.gridy = 2;
		buttonPanel.add(btnWithdraw, gbc);

		gbc.gridy = 3;
		buttonPanel.add(btnExit, gbc);

		appFrame.add(buttonPanel, BorderLayout.CENTER);

	}

	private JButton setupShowBalanceButton() {
		//Button für Option A
		JButton btnShowBalance = new JButton("Kontostand anzeigen");
		btnShowBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance = TransactionsServices.getbalance();
				JOptionPane.showMessageDialog(appFrame, "Der Kontostand beträgt: " + balance + "€");

			}
		});
	return btnShowBalance;
	}

	private JButton setupDepositButton() {
		//Button für B
		JButton btnDeposit = new JButton("Einzahlen");
		btnDeposit.addActionListener(e -> {
			String depositStr = JOptionPane.showInputDialog(appFrame,
					"Geben Sie den Einzahlungsbetrag ein:" , "Einzahlung", JOptionPane.PLAIN_MESSAGE);
			try {
				double depositAmount = Double.parseDouble(depositStr);
				TransactionsServices.deposit(depositAmount);
				JOptionPane.showMessageDialog(appFrame, "Einzahlung von " + depositAmount + "€ erfolgreich durchgeführt.");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(appFrame,
						"Ungültiges Format. Bitte geben Sie eine gültige Zahl ein.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		});
	return btnDeposit;
	}

	private JButton setupExitButton() {
		JButton btnExit = new JButton("Beenden");
		btnExit.addActionListener(e -> showExitMessage());
		return btnExit;
	}

	public void show() {
		appFrame.setPreferredSize(new Dimension(1000, 1000));
		appFrame.setAlwaysOnTop(true);
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}
