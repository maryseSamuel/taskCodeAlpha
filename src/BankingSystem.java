import java.util.Scanner;

public class BankingSystem {
    private static double total_balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Welcome, " + userName + ", to the Banking System!");

        int choice;

        do {
            System.out.println("\nBanking Options for " + userName);
            System.out.println("a. Make a Deposit");
            System.out.println("b. Withdraw Funds");
            System.out.println("c. Check total balance");
            System.out.println("d. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Enter an amount to deposit in Egyptian Pound: LE ");
                    double amount = sc1.nextDouble();

                    if (amount > 0) {
                        total_balance += amount;
                        System.out.println("Deposit made successfully!!! New total balance: "+ total_balance+" LE " );
                    } else if(amount < 0){
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    else {
                        System.out.println("Invalid amount. Please enter a valid value.");
                    }
                    break;

                case 'b':
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Enter the amount to withdraw in Egyptian Pound: LE ");
                    double amount2 = sc2.nextDouble();

                    if (amount2 > 0 && amount2 <= total_balance) {
                        total_balance -= amount2;
                        System.out.println("Withdrawal successful. New total balance: "+ total_balance+" LE ");
                    } else if (amount2 > total_balance) {
                        System.out.println("Insufficient funds. Your total balance: "+ total_balance+" LE ");
                    } else {
                        System.out.println("Invalid amount. Please enter a positive or a valid value.");
                    }
                    break;

                case 'c':
                    System.out.println("Your current balance, " + userName + " is: "+total_balance +" LE " );
                    break;

                case 'd':
                    System.out.println("Exiting the program. Thank you, " + userName + "!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again, " + userName + ".");
            }
        } while (choice != 'd');

        scanner.close();
    }


}
