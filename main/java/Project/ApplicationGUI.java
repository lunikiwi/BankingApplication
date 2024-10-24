package Project;
import javax.swing.*;
import java.awt.*;

public class ApplicationGUI {
	private JTextField customernameField;
	private JPasswordField passwordField;
	private static JFrame appFrame;
	private BankAccount bankAccount;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JPanel mainPanel;
	private CardLayout cardLayout;

	public ApplicationGUI(String customerName, String customerID) {
		CustomerServices.loadCustomerCredentials();
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

		customernameField = new JTextField("Customer name", 15);
		customernameField.setForeground(Color.GRAY);
		customernameField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (customernameField.getText().equals("Customer name")) {
					customernameField.setText("");
					customernameField.setForeground(Color.BLACK);
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if (customernameField.getText().isEmpty()) {
					customernameField.setForeground(Color.GRAY);
					customernameField.setText("Customer name");
				}
			}
		});

		passwordField = new JPasswordField("Password", 15);
		passwordField.setForeground(Color.GRAY);
		passwordField.setEchoChar((char) 0); // Show the placeholder text
		passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (new String(passwordField.getPassword()).equals("Password")) {
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
					passwordField.setEchoChar('\u2022'); // Set the echo char to hide the password
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if (new String(passwordField.getPassword()).isEmpty()) {
					passwordField.setForeground(Color.GRAY);
					passwordField.setText("Password");
					passwordField.setEchoChar((char) 0); // Show the placeholder text
				}
			}
		});

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> login());

		loginPanel.add(customernameField);
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
		idLabel = new JLabel("CustomerID: " + bankAccount.getcustomerID());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(idLabel);
		parentPanel.add(labelPanel, BorderLayout.NORTH);
	}

	private void setupButtons(JPanel parentPanel) {
		JButton btnDeposit = Buttons.setupDepositButton(bankAccount);
		JButton btnShowBalance = Buttons.setupShowBalanceButton(bankAccount);
		JButton btnWithdraw = Buttons.setupWithdrawButton(bankAccount);
		JButton btnExit = Buttons.setupExitButton();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = createGbc();
		addButtonToPanel(buttonPanel, btnShowBalance, gbc, 0);
		addButtonToPanel(buttonPanel, btnDeposit, gbc, 1);
		addButtonToPanel(buttonPanel, btnWithdraw, gbc, 2);
		addButtonToPanel(buttonPanel, btnExit, gbc, 3);
		parentPanel.add(buttonPanel, BorderLayout.CENTER);
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
		String enteredUsername = customernameField.getText();
		String enteredPassword = new String(passwordField.getPassword());

		if (CustomerServices.validateLogin(enteredUsername, enteredPassword)) {
			Customer authenticatedCustomer = Customer.getAllcustomers().get(enteredUsername);
			this.bankAccount = authenticatedCustomer.getBankAccount();

			nameLabel.setText("Welcome. You're currently logged in as " + bankAccount.getcustomerName());
			idLabel.setText("CustomerID: " + bankAccount.getcustomerID());

			cardLayout.show(mainPanel, "mainApp");
		} else {
			JOptionPane.showMessageDialog(appFrame, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void show() {
		appFrame.setPreferredSize(new Dimension(1000, 1000));
		appFrame.setAlwaysOnTop(true);
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
}
