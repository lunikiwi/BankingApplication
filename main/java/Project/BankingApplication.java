package Project;


public class BankingApplication {

	public static void main(String[] args) {
		UserServices.loadUserCredentials();
		ApplicationGUI applicationGUI = new ApplicationGUI(customerName, customerID);
		applicationGUI.show();
	}

}


