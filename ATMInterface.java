import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        balance += amount;
        return true;
    }
}

class ATM {

    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.printf("Current Balance: $%.2f%n",
                account.getBalance());
    }

    public void withdraw(double amount) {

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
            checkBalance();
        }
    }

    public void deposit(double amount) {

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
            checkBalance();
        }
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
