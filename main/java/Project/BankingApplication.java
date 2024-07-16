package Project;//Ideas for this project: append GUI, transactions between different users

import java.util.Map;
import java.util.Random;
import java.util.Scanner;



public class BankingApplication {
	static Scanner consoleScanner =  new Scanner(System.in);

	public static void main(String[] args) {
		//call authenticateUser, creates new user, if ID isn't contained in HashMap
		UserServices.loadUserCredentials();
		BankAccount bankAccount = authenticateUser();

		ApplicationGUI meinGui = new ApplicationGUI(bankAccount);
		meinGui.show();
		//bankAccount.displayMenu();
		closeConsoleScanner();

	}

	public static void closeConsoleScanner() {
		consoleScanner.close();
	}

	public static BankAccount authenticateUser() {
    	System.out.println("Bitte Benutzername eingeben:");
   		String usernameInput = consoleScanner.nextLine();
  		Map<String, User> usertoauthenticate = User.getAllUsers(); //makes no sense, need 1 user not map of users

		if (usertoauthenticate != null && usertoauthenticate.equals(userpassword)) { //user instead of User!! big difference
			return usertoauthenticate.getBankAccount();

		}
		else {
			System.out.println("Benutzer existiert nicht, neuer Benutzer wird erstellt");
        	System.out.println("Bitte geben Sie Ihren Vor- und Nachnamen ein:");

			String name = consoleScanner.nextLine();
       	 	String randomID = generateRandomID();
       	 	BankAccount newAccount = new BankAccount(name, randomID);

			User newUser = new User(usernameInput, "hardcodedpassword", newAccount);

        	System.out.println("Ihr neuer Benutzername lautet: " + usernameInput);
        	return newUser.getBankAccount();
        }

	}

	 public static String generateRandomID() {
		 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 String digits = "0123456789";
		 StringBuilder randomID = new StringBuilder();
		 
		 //Zufällige Buchstaben
		 randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
		 randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
		 
		 //Zufällige Ziffern
		 for (int i = 0; i < 4; i++) {
			 randomID.append(digits.charAt(new Random().nextInt(digits.length())));
			 
		 }
		 
		 //Zufällige Buchstaben
		 //Diese Codezeile kommt aus Java und ist zum Generieren einer zufälligen alphanumerischen Zeichenkette (String) nützlich.
		 //Random().nextInt(alphabet.length()) erzeugt eine Zufallszahl innerhalb der Grenzen von 0 (inklusiv) bis zur Länge von alphabet (exklusiv). 
		 //D.h. wenn dein alphabet darin besteht, das Standardenglisch-Alphabet von 26 Buchstaben zu verwenden, wird hier eine Zufallszahl zwischen 0 und 25 erzeugt.
		 //alphabet.charAt(...) nimmt den Buchstaben an der Stelle des generierten Zufallsindex aus dem alphabet-String.
		 //randomID.append(...) fügt den generierten zufälligen Buchstaben zum StringBuilder oder StringBuffer randomID hinzu. Dies wird in der Regel in einer Schleife gemacht, um eine Zeichenkette von zufälligen Zeichen mit einer bestimmten Länge zu erstellen.
		 //Zusammen genommen, erzeugt diese Zeile zufällige Zeichen basierend auf dem gegebenen Alphabet und fügt sie zum randomID an.
		 randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
		 randomID.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
		 
		 //Ziffern enthalten, Konvertierung der ganzen Zeichenkette zu String
		 return randomID.toString();
	 }
	
}


