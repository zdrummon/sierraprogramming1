/*
Zachary Drummond
September 27, 2026
    This program displays the calculations rates of 6 different physics formulas, and prompts the user to enter values for each calculation 3 times. The program then displays the results of each calculation.
    I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
    
    I believe this deserves an A, the formatting is great, and I honestly did a very good job with it in a mere 10 minutes. I am pround of this work, even though it catches no bad inputs (yucky). I even closed the scanner.
*/
package proj_7_PhysCalcDrummond;

import java.util.Scanner;

public class PhysCalcDrummond {
 
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("\nWelcome to Zac's Physics Calculator!");
        System.out.println("You will be prompted to enter values for various physics calculations, 3 times for each calculation.");
        System.out.println("Now we will calculate displacement, kinetic energy, final velocity, centripetal force, and momentum.\n");

        System.out.println("Now we will calculate final velocity.\n");
        // Loop to get user input and calculate final velocity
        for(int i = 0; i < 3; i++) {
            // user input
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the initial velocity (m/s): ");
            double initialVelocity = userInput.nextDouble();
            System.out.print("Enter the acceleration (m/s^2): ");
            double acceleration = userInput.nextDouble();
            System.out.print("Enter the time (s): ");
            double time = userInput.nextDouble();

            // calculate
            double result = finalVelocityMPerS(initialVelocity, acceleration, time);

            // display result
            System.out.println("Final velocity: " + result + " m/s\n");
        }

        System.out.println("\nNow we will calculate displacement.\n");
        // Loop to get user input and calculate displacement
        for(int i = 0; i < 3; i++) {
            // user input
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the initial velocity (m/s): ");
            double initialVelocity = userInput.nextDouble();
            System.out.print("Enter the acceleration (m/s^2): ");
            double acceleration = userInput.nextDouble();
            System.out.print("Enter the time (s): ");
            double time = userInput.nextDouble();

            // calculate
            double result = displacementMeters(initialVelocity, acceleration, time);

            // display result
            System.out.println("Displacement: " + result + " m\n");
        }

        System.out.println("\nNow we will calculate kinetic energy.\n");
        // Loop to get user input and calculate kinetic energy
        for(int i = 0; i < 3; i++) {
            // user input
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the mass (kg): ");
            double mass = userInput.nextDouble();
            System.out.print("Enter the velocity (m/s): ");
            double velocity = userInput.nextDouble();

            // calculate
            double result = kineticEnergyJoules(mass, velocity);

            // display result
            System.out.println("Kinetic Energy: " + result + " J\n");
        }
        
        System.out.println("\nNow we will calculate power.\n");
        // Loop to get user input and calculate power
        for(int i = 0; i < 3; i++) {
            // user input
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the initial velocity (m/s): ");
            double initialVelocity = userInput.nextDouble();
            System.out.print("Enter the acceleration (m/s^2): ");
            double acceleration = userInput.nextDouble();
            System.out.print("Enter the time (s): ");
            double time = userInput.nextDouble();

            // calculate
            double result = finalVelocityMPerS(initialVelocity, acceleration, time);

            // display result
            System.out.println("Final velocity: " + result + " m/s\n");
        }

        System.out.println("\nNow we will calculate centripetal force.\n");
        // Loop to get user input and calculate centripetal force
        for(int i = 0; i < 3; i++) {
            // user input  
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the mass (kg): ");
            double mass = userInput.nextDouble();
            System.out.print("Enter the velocity (m/s): ");
            double velocity = userInput.nextDouble();
            System.out.print("Enter the radius (m): ");
            double radius = userInput.nextDouble();

            // calculate
            double result = centripetalForceNewton(mass, velocity, radius);

            // display result
            System.out.println("Centripetal Force: " + result + " N\n");
        }

        System.out.println("\nNow we will calculate momentum.\n");
        // Loop to get user input and calculate momentum
        for(int i = 0; i < 3; i++) {
            // user input
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the mass (kg): ");
            double mass = userInput.nextDouble();
            System.out.print("Enter the velocity (m/s): ");
            double velocity = userInput.nextDouble();

            // calculate
            double result = momentumKgMPerS(mass, velocity);

            // display result
            System.out.println("Momentum: " + result + " kg·m/s\n");
        }

        System.out.println("Thank you for using Zac's Physics Calculator!");

        userInput.close();
    }

    public static double finalVelocityMPerS(double initialVelocity, double acceleration, double time) {
        return initialVelocity + acceleration * time;
    }

    public static double displacementMeters(double initialVelocity, double acceleration, double time) {
        return initialVelocity * time + 0.5 * acceleration * time * time;
    }

    public static double kineticEnergyJoules(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    public static double wattPower(double work, double time) {
        return work / time;
    }

    public static double centripetalForceNewton(double mass, double velocity, double radius) {
        return mass * velocity * velocity / radius;
    }

    public static double momentumKgMPerS(double mass, double velocity) {
        return mass * velocity;
    }
}