package CODSOFT;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialAmount) {
        this.balance = initialAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
            return true;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Menu :");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            displayMenu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Please take your money.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your balance is: Rs " + account.getBalance());
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(2000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
