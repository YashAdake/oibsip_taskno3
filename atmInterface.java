import java.util.ArrayList;
import java.util.Scanner;

public class atmInterface {

    double balance;
    ArrayList<String> username = new ArrayList<String>();
    ArrayList<Double> amt = new ArrayList<Double>();

    public atmInterface() {
        balance = 0;
        // username = null;
        // amt = null;
    }

    public static void main(String args[]) {

        atmInterface atm = new atmInterface();

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "\n\n-----------------------------------------| Welcome to ATM service |-----------------------------------------\n");

        int pass = 0;
        while (pass != 4321) {

            System.out.println("Enter your id:");
            int id;
            id = sc.nextInt();

            System.out.println("Enter your password:");
            pass = sc.nextInt();
            if (pass != 4321) {
                System.out.println("User id and Password didn't matched!\n");
            }
        }

        int op = 0;
        while (op != 5) {

            System.out.println("\nChoose Service:\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Exit");
            op = sc.nextInt();
            double amt;

            switch (op) {

                case 1:
                    System.out.println("Enter amount to deposit:");
                    amt = sc.nextDouble();
                    atm.deposit(amt);
                    System.out.println("New Balance:" + atm.balance + "\n");
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    amt = sc.nextDouble();
                    atm.withdraw(amt);
                    System.out.println("New Balance:" + atm.balance + "\n");
                    break;

                case 3:
                    System.out.println("Enter username of recipient:");
                    String name = sc.next();

                    System.out.println("Enter amount to transfer:");
                    amt = sc.nextDouble();

                    atm.transfer(name, amt);

                    break;

                case 4:
                    atm.transactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you......");
                    break;

                default:
                    System.out.println("Wrong input!.");

            }

        }

    }

    void transactionHistory() {
        if (amt.size() > 0) {
            for (int i = 0; i < amt.size(); i++) {
                System.out.println((i + 1) + "> " + username.get(i) + " " + amt.get(i));
            }

        } else {
            System.out.println("No transaction done.");
        }

    }

    void withdraw(double amt) {
        if (balance < amt) {
            System.out.println("Balance insufficiant, can't perform withdraw.");
        } else {
            balance -= amt;
        }
    }

    void deposit(double amt) {
        balance += amt;
    }

    void transfer(String name, double amt) {
        if (balance < amt) {
            System.out.println("Balance insufficiant, can't perform transfer.");
        }

        else {
            username.add(name);
            this.amt.add(amt);
            balance -= amt;
            System.out.println("Transfer Complete");

        }

    }

}
