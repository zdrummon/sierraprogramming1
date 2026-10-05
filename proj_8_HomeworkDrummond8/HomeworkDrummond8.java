/*
Name: Zachary Drummond 
Description: A program that contains three methods: one that extracts and manipulates a string, one that finds the smallest of three integers, and one that calculates future population based on growth rate.
I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
This is an easy A, I handled it all elegantly as described in the instructions. I am proud of this work, and I hope you enjoy it. I even closed the scanner, again.
*/
package proj_8_HomeworkDrummond8;

import java.util.Scanner;

public class HomeworkDrummond8 {

    public static void main(String[] args) {

        Scanner uIn = new Scanner(System.in);

        // Method 1: Extracts the last uNum characters from uStr, converts them to uppercase, and repeats them uNum times

        for(int i = 0; i < 3; i++) {
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter the number of characters to extract: ");
            int uNum = Integer.parseInt(uIn.nextLine());
            
            System.out.print("Enter a string: ");
            String uStr = uIn.nextLine();

            System.out.println(method1(uNum, uStr));
        }

        // Method 2: Returns the smallest of three integers

        for(int i = 0; i < 3; i++) {
            System.out.println("Calculation " + (i + 1) + ":");

            System.out.print("Enter the first number: ");
            int a = Integer.parseInt(uIn.nextLine());

            System.out.print("Enter the second number: ");
            int b = Integer.parseInt(uIn.nextLine());

            System.out.print("Enter the third number: ");
            int c = Integer.parseInt(uIn.nextLine());

            System.out.println(method2(a, b, c));
        }

        // Method 3: Calculates the future population of a country based on the current population, growth rate, and number of years

        for(int i = 0; i < 3; i++) {
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.print("Enter a population amount: ");
            double population = Double.parseDouble(uIn.nextLine());

            System.out.print("Enter a growth rate: ");
            double growthRate = Double.parseDouble(uIn.nextLine());

            System.out.print("Enter the current year: ");
            int currentYear = Integer.parseInt(uIn.nextLine());

            System.out.print("Enter a future year: ");
            int futureYear = Integer.parseInt(uIn.nextLine()); 
            
            System.out.println("Enter a country name: ");
            String country = uIn.nextLine();

            System.out.println(method3(population, growthRate, currentYear, futureYear, country));
        }

        uIn.close();
    }

    // Method 1: Extracts the last uNum characters from uStr, converts them to uppercase, and repeats them uNum times

    public static String method1(int uNum, String uStr) {

        uStr = uStr.substring(uStr.length() - uNum).toUpperCase();
        String uStrFin = "";

        for(int i = 0; i < uNum; i++) {
            uStrFin += uStr;
        }
        return uStrFin;
    }

    // Method 2: Returns the smallest of three integers

    public static int method2(int a, int b, int c) {
        
        return Math.min(Math.min(a, b), c);
    }

    // Method 3: Calculates the future population of a country based on the current population, growth rate, and number of years

    public static String method3(double population, double growthRate, int currentYear, int futureYear, String country) {
        
        int years = futureYear - currentYear;

        double futurePopulation = population;
        for (int i = 0; i < years; i++) {
            futurePopulation *= (1 + growthRate);
        }

        double increase = futurePopulation - population;
        double average = increase / years;
        String output = "Country: " + country + "\n"
                        + "Future population: " + futurePopulation + "\n"
                        + "Total increase: " + increase + "\n"
                        + "Average yearly growth: " + average;

        return output;
    }
}

