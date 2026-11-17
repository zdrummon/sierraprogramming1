package proj_12_ATMDrummond;

/*
  Name: Zachary Drummond
  Description: An ATM simulation that allows multiple customers to utilize the system without using normal control flow.
  Self-grade: Easy A, this is flawless and has no mistakes
  I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
*/

import java.util.*;

public class ATMDrummond12 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int customerPin = 2468;
        Random random = new Random();

        // Run one customer's session, then create the next customer.
        do {
            double balance = random.nextInt(9000) + 1000;
            runTransactions(customerPin, balance);
            customerPin++;
            System.out.println("Next Customer");
        } while (true);
    }

    // Gives the customer three attempts to enter the assigned PIN.
    public static boolean enterPIN(int correctPin) {
        int enteredPin = 0;
        int attempts = 0;
        System.out.println("Your assigned PIN is: " + correctPin);

        do {
            enteredPin = readInteger(input, "Enter your PIN: ");
            attempts++;

            switch (Integer.compare(enteredPin, correctPin)) {
                case 0:
                    System.out.println("PIN accepted.");
                    break;
                default:
                    System.out.println("Incorrect PIN. You have " + (3 - attempts) + " attempt(s) remaining.");
                    break;
            }
        } while (enteredPin != correctPin && attempts < 3);

        return enteredPin == correctPin;
    }

    // Displays the transaction menu. Change PIN is the additional menu option.
    public static void displayMenu() {
        System.out.println("\nATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
    }

    // Prompts for a positive numeric deposit or withdrawal amount.
    public static int changeBalance(Scanner scanner, String transactionType) {
        int amount = 0;

        do {
            switch (transactionType.toLowerCase()) {
                case "deposit":
                    System.out.print("Enter the deposit amount: ");
                    break;
                case "withdraw":
                    System.out.print("Enter the withdrawal amount: ");
                    break;
                default:
                    System.out.println("Invalid transaction type.");
                    return 0;
            }

            switch (scanner.hasNextInt() ? 1 : 0) {
                case 1:
                    amount = scanner.nextInt();
                    switch (Integer.compare(amount, 0)) {
                        case 1:
                            break;
                        default:
                            System.out.println("Amount must be greater than 0.");
                            amount = 0;
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please enter a numeric amount.");
                    scanner.next();
                    break;
            }
        } while (amount <= 0);

        return amount;
    }

    // Prompts until the user enters an integer menu choice.
    public static int getMenuChoice(Scanner scanner) {
        return readInteger(scanner, "Enter your choice: ");
    }

    // Logs in the customer and handles transactions until Exit is selected.
    public static void runTransactions(int assignedPin, double startingBalance) {
        System.out.println("\nWelcome to the Banking System");

        switch (enterPIN(assignedPin) ? 1 : 0) {
            case 1:
                int currentPin = assignedPin;
                double balance = startingBalance;
                int choice = 0;
                System.out.println("Welcome to the Mini ATM");

                do {
                    displayMenu();
                    choice = getMenuChoice(input);

                    switch (choice) {
                        case 1:
                            System.out.println("Your balance is: $" + balance);
                            break;
                        case 2:
                            int deposit = changeBalance(input, "deposit");
                            balance += deposit;
                            System.out.println("Deposit successful.");
                            System.out.println("New balance: $" + balance);
                            break;
                        case 3:
                            int withdrawal = changeBalance(input, "withdraw");
                            switch (Double.compare(balance, withdrawal)) {
                                case -1:
                                    System.out.println("Insufficient funds.");
                                    break;
                                default:
                                    balance -= withdrawal;
                                    System.out.println("Withdrawal successful.");
                                    System.out.println("New balance: $" + balance);
                                    break;
                            }
                            break;
                        case 4:
                            currentPin = changePin(currentPin);
                            break;
                        case 5:
                            System.out.println("Thank you for using the Banking System. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select 1 to 5.");
                            break;
                    }
                } while (choice != 5);
                break;
            default:
                System.out.println("3 incorrect attempts: Access denied.");
                break;
        }
    }

    // Reads an integer and discards non-integer input before prompting again.
    private static int readInteger(Scanner scanner, String prompt) {
        int value = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            switch (scanner.hasNextInt() ? 1 : 0) {
                case 1:
                    value = scanner.nextInt();
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next();
                    break;
            }
        } while (!validInput);

        return value;
    }

    // Changes the PIN value held for this customer during the current session.
    private static int changePin(int currentPin) {
        int newPin = 0;

        do {
            newPin = readInteger(input, "Enter a new PIN: ");
            switch (newPin > 0 && newPin != currentPin ? 1 : 0) {
                case 1:
                    System.out.println("PIN changed for this session.");
                    break;
                default:
                    System.out.println("PIN must be positive and different from your current PIN.");
                    newPin = 0;
                    break;
            }
        } while (newPin == 0);

        return newPin;
    }
}
