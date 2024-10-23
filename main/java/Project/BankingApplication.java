package Project;


public class BankingApplication {

	public static void main(String[] args) {
		UserServices.loadUserCredentials();
		BankAccount bankAccount = authenticateUser();
		ApplicationGUI myGui = new ApplicationGUI(bankAccount);
		myGui.show();
	}


	
}


