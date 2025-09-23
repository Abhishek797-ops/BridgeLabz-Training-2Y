import java.util.Scanner;
public class ATMMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do { 
            System.out.println("\n --- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Your balance is 10,000");
                case 2 -> System.out.println("Withdraw Successful");
                case 3 -> System.out.println("Deposit Successful");
                case 4 -> System.out.println("Thank you for using ATM!");
                default -> System.out.println("Invalid choice!");
                    
            }
        }while (choice !=4);
    }
    
}
