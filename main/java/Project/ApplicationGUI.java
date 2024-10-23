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
	private JPanel mainPanel;
	private CardLayout cardLayout;

	public ApplicationGUI(String customerName, String customerID) {
		this.bankAccount = new BankAccount(customerName, customerID);
		setupMainFrame();
		setupCardLayout();
		setupLoginWindow();
		setupMainApplicationView();
		show();
	}

	public static JFrame getAppFrame() {
		return appFrame;
	}
	private void setupMainFrame() {
		appFrame = new JFrame("Banking Application");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setLayout(new BorderLayout());
	}

	private void setupCardLayout() {
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		appFrame.add(mainPanel, BorderLayout.CENTER);
	}

	public void setupLoginWindow() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

		usernameField = new JTextField("User name", 15);
		passwordField = new JPasswordField("Password", 15);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> login());

		loginPanel.add(usernameField);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);

		mainPanel.add(loginPanel, "login");
	}

	private void setupMainApplicationView() {
		JPanel mainAppPanel = new JPanel(new BorderLayout());

		setupLabels(mainAppPanel);
		setupButtons(mainAppPanel);

		mainPanel.add(mainAppPanel, "mainApp");
	}
	private void setupLabels(JPanel parentPanel) {
		nameLabel = new JLabel("Welcome. You're currently logged in as " + bankAccount.getcustomerName());
		idLabel = new JLabel("UserID: " + bankAccount.getcustomerID());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(idLabel);
		appFrame.add(labelPanel, BorderLayout.NORTH);

	}

	private void setupButtons(JPanel parentPanel) {
		JButton btnShowBalance = Buttons.setupDepositButton(bankAccount);
		JButton btnDeposit = Buttons.setupShowBalanceButton(bankAccount);
		JButton btnWithdraw = Buttons.setupWithdrawButton(bankAccount);
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

	private void login() {
		// Perform login logic here
		// If login is successful, switch to main application view
		cardLayout.show(mainPanel, "mainApp");
	}

	public void show() {
		appFrame.setPreferredSize(new Dimension(1000, 1000));
		appFrame.setAlwaysOnTop(true);
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}
