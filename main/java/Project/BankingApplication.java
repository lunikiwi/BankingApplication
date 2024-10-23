package Project;

public class BankingApplication {

	public static void main(String[] args) {
		CustomerServices.loadCustomerCredentials();
		ApplicationGUI applicationGUI = new ApplicationGUI(null, null);
		applicationGUI.show();
	}

}


