package Project;

import javax.swing.*;
import java.awt.*;

public class ApplicationGUI {
	private JTextField usernameField;
	private JTextField passwordField;
	private static JFrame appFrame;
	private BankAccount bankAccount;
	private JLabel nameLabel;
	private JLabel idLabel;
	//GridBagLayout gbl = new GridBagLayout();

	/*
	public ApplicationGUI(BankAccount newAccount) {
		this.bankAccount01 = newAccount;
		setupMainFrame();
		setupLabels();
		setupButtons();
	}
	*/

	public ApplicationGUI(String customerName, String customerID) {
		this.bankAccount = new BankAccount(customerName, customerID);
		setupMainFrame();
		setupLabels();
		setupButtons();

	}

	private void setupMainFrame() {
		appFrame = new JFrame("Banking Application");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setLayout(new BorderLayout());
	}

	public static JFrame getAppFrame() {
		return appFrame;
	}

	public void LoginWindow() {
		usernameField = new JTextField("User name", 15);
		usernameField.add(usernameField);
		passwordField = new JPasswordField("Password", 15);
		usernameField.add(passwordField);

	}

	private void setupLabels() {
		nameLabel = new JLabel("Welcome. You're currently logged in as " + bankAccount.getcustomerName());
		idLabel = new JLabel("UserID: " + bankAccount.getcustomerID());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(idLabel);
		//labelPanel.add(exit)
		appFrame.add(labelPanel, BorderLayout.NORTH);

	}

	private void setupButtons() {
		JButton btnShowBalance = Buttons.setupDepositButton();
		JButton btnDeposit = Buttons.setupShowBalanceButton();
		JButton btnWithdraw = Buttons.setupWithdrawButton();
		JButton btnExit = Buttons.setupExitButton();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = createGbc();

		addButtonToPanel(buttonPanel, btnShowBalance, gbc, 0);
		addButtonToPanel(buttonPanel, btnDeposit, gbc, 1);
		addButtonToPanel(buttonPanel, btnWithdraw, gbc, 2);
		addButtonToPanel(buttonPanel, btnExit, gbc, 3);

		appFrame.add(buttonPanel, BorderLayout.CENTER);

	}

	private GridBagConstraints createGbc() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 10);
		return gbc;
	}

	private void addButtonToPanel(JPanel panel, JButton button, GridBagConstraints gbc, int gridy) {
		gbc.gridy = gridy;
		panel.add(button, gbc);
	}


	public void show() {
		appFrame.setPreferredSize(new Dimension(1000, 1000));
		appFrame.setAlwaysOnTop(true);
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}
