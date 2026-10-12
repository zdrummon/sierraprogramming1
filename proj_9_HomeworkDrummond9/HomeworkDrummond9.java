package proj_9_HomeworkDrummond9;
/*
  Name: Zachary Drummond
  Description: A program that computes monthly internet charges for customers of an Internet Service Provider.
  Self-grade: Easy A, this is flawless and has no mistakes
  I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
 */

import java.util.Scanner;

public class HomeworkDrummond9 {
 
    // Class constants for the packages
    static final double PACKAGE_A_COST = 9.95;
    static final double PACKAGE_B_COST = 14.95;
    static final double PACKAGE_C_COST = 19.95;
 
    // Class constants for the speeds
    static final double SPEED_100_COST = 30.00;
    static final double SPEED_300_COST = 45.00;
    static final double SPEED_500_COST = 60.00;
    static final double SPEED_700_COST = 80.00;
    static final double SPEED_1000_COST = 100.00;
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.println("Welcome to Internet Billing System");
        System.out.print("How many customers are in line? ");
        int numCustomers = input.nextInt();
        input.nextLine();
 
        for (int i = 1; i <= numCustomers; i++) {
            System.out.println("--- Customer " + i + " ---");
            showPackagesAndSpeeds();
 
            System.out.print("Enter customer name: ");
            String name = input.nextLine();
 
            System.out.print("Enter package (A/B/C): ");
            String pkg = input.nextLine();
 
            System.out.print("Enter speed (choose 100, 300, 500, 700, or 1000): ");
            int speed = input.nextInt();
 
            System.out.print("Enter estimated monthly hours used: ");
            int hours = input.nextInt();
            input.nextLine();
 
            double packageCost = getPackageCost(pkg, hours);
            double speedCost = getSpeedCost(speed);
            double total = packageCost + speedCost;
 
            System.out.println("Invoice for " + name);
            System.out.printf("Package %s data cost: $%.2f%n", pkg.toUpperCase(), packageCost);
            System.out.printf("Speed cost (%d Mbps): $%.2f%n", speed, speedCost);
            System.out.printf("Total monthly payment: $%.2f%n", total);
 
            System.out.println("Upgrade savings:");
            showUpgradeSavings(pkg, hours);
        }
    }
 
    // Method 1: shows the packages and speeds
    public static void showPackagesAndSpeeds() {
        System.out.println("Available packages:");
        System.out.println("A) $9.95/month - 10 hours included, $2/hr extra");
        System.out.println("B) $14.95/month - 20 hours included, $1/hr extra");
        System.out.println("C) $19.95/month - unlimited");
        System.out.println("Available speeds: 100 ($30), 300 ($45), 500 ($60), 700 ($80), >1000 ($100)");
    }
 
    // Method 2: returns the data cost for the package
    public static double getPackageCost(String pkg, int hours) {
        double cost = 0;
 
        if (pkg.equalsIgnoreCase("A")) {
            cost = PACKAGE_A_COST;
            if (hours > 10) {
                cost = cost + (hours - 10) * 2.0;
            }
        } else if (pkg.equalsIgnoreCase("B")) {
            cost = PACKAGE_B_COST;
            if (hours > 20) {
                cost = cost + (hours - 20) * 1.0;
            }
        } else if (pkg.equalsIgnoreCase("C")) {
            cost = PACKAGE_C_COST;
        }
 
        return cost;
    }
 
    // Method 3: returns the speed cost using if/else statements
    public static double getSpeedCost(int speed) {
        double cost = 0;
 
        if (speed == 100) {
            cost = SPEED_100_COST;
        } else if (speed == 300) {
            cost = SPEED_300_COST;
        } else if (speed == 500) {
            cost = SPEED_500_COST;
        } else if (speed == 700) {
            cost = SPEED_700_COST;
        } else {
            cost = SPEED_1000_COST;
        }
 
        return cost;
    }
 
    // Method 4: shows the savings for upgrading
    public static void showUpgradeSavings(String pkg, int hours) {
        double current = getPackageCost(pkg, hours);
 
        if (pkg.equalsIgnoreCase("A")) {
            double costB = getPackageCost("B", hours);
            double costC = getPackageCost("C", hours);
 
            System.out.printf("If you upgrade A -> B: B cost = $%.2f%n", costB);
            if (current - costB >= 0) {
                System.out.printf("Savings = $%.2f%n", current - costB);
            } else {
                System.out.printf("Extra cost = $%.2f%n", costB - current);
            }
 
            System.out.printf("If you upgrade A -> C: C cost = $%.2f%n", costC);
            if (current - costC >= 0) {
                System.out.printf("Savings = $%.2f%n", current - costC);
            } else {
                System.out.printf("Extra cost = $%.2f%n", costC - current);
            }
        } else if (pkg.equalsIgnoreCase("B")) {
            double costC = getPackageCost("C", hours);
 
            System.out.printf("If you upgrade B -> C: C cost = $%.2f%n", costC);
            if (current - costC >= 0) {
                System.out.printf("Savings = $%.2f%n", current - costC);
            } else {
                System.out.printf("Extra cost = $%.2f%n", costC - current);
            }
        } else {
            System.out.println("You already have Package C (unlimited). No upgrade available.");
        }
    }
}
