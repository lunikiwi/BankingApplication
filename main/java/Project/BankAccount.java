package Project;

class BankAccount {
    public static double accountBalance;
    public static double previousTransaction;
    private String customerName;
    private String customerID;

    BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }
    public String getcustomerName() {
        return customerName;
    }

    public String getcustomerID() {
        return customerID;
    }



}
    /*
    void displayOptions() {
        System.out.println("===============================================");
        System.out.println("Menü auswählen");
        System.out.println("===============================================");
        System.out.println("A. Kontostand anzeigen");
        System.out.println("B. Einzahlung");
        System.out.println("C. Auszahlung");
        System.out.println("D. Vorherige Transaktion");
        System.out.println("E. Beenden");
        System.out.println("\n");
    }

    void displayMenu() {

        char selectedOption ='\0';  //setzt Variable "Option" auf Nullzeichen, wird später überschrieben von Nutzereingabe
        Scanner consoleScanner = BankingApplication.consoleScanner;
        System.out.println("\n");
        System.out.println("Guten Tag " + customerName);
        System.out.println("Ihre ID ist " + customerID);
        System.out.println("\n");

        do {
            displayOptions();
            selectedOption = Character.toUpperCase(consoleScanner.nextLine().trim().charAt(0));
            System.out.println("\n");

            switch(selectedOption) {

                case 'A':
                    System.out.println("--------------------------------------------");
                    System.out.println("Kontostand: " + accountBalance + "€");
                    System.out.println("--------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------------------------------");
                    System.out.println("Einzuzahlenden Betrag in € eingeben");
                    System.out.println("--------------------------------------------");
                    int Menge1 = consoleScanner.nextInt();
                    deposit(Menge1);
                    System.out.println("\n");
                    consoleScanner.nextLine();
                    break;

                case 'C':
                    System.out.println("--------------------------------------------");
                    System.out.println("Auszuzahlenden Betrag in € eingeben");
                    System.out.println("--------------------------------------------");
                    int Menge2 = consoleScanner.nextInt();
                    withdraw(Menge2);
                    System.out.println("\n");
                    consoleScanner.nextLine();
                    break;

                case 'D':
                    System.out.println("--------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E' :
                    System.out.println("Danke, dass Sie unseren Service nutzen");
                    break;

                default:
                    System.out.println("Fehlerhaft Eingabe, bitte erneut probieren!");
                    break;
            }

        }  while(selectedOption != 'E');
        //consoleScanner.close();
        //System.out.println("Danke, dass Sie unseren Service nutzen");
    } */


