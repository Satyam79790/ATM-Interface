import java.util.*;
class ATM {
    private double balance;
    private String pin;

    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000, "1234");
        
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.next();
        
        if (!atm.authenticate(enteredPin)) {
            System.out.println("Incorrect PIN. Exiting...");
            scanner.close();
            return;
        }
        
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) atm.checkBalance();
            else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                atm.deposit(scanner.nextDouble());
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                atm.withdraw(scanner.nextDouble());
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
