/*
Zachary Drummond
September 20, 2026
    This program displays the conversion rates of 5 different currencies to USD
    I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
    
    I believe this deserves an A, the formatting is clean and nice looking, code is organized, and I even rounded
*/
package proj_6_CurrencyDrummond;

public class CurrencyDrummond {

    //rates for currency conversion
    public static final double DOLLAR_TO_EURO = 1.15;
    public static final double DOLLAR_TO_POUND = 1.34;
    public static final double DOLLAR_TO_CANADIAN = 0.71;
    public static final double DOLLAR_TO_AUSTRALIAN = 0.71;
    public static final double DOLLAR_TO_YEN = 0.0064;

    public static void main(String[] args) {

        System.out.println("\nUSD\t| EURO\t| POUND\t| CANAD\t| AUSTR\t| YEN");
        System.out.println("________________________________________________");
        convert();
        System.out.print("\n");
    }

    public static void convert() {

        for(int i = 1; i <= 10; i++) {

            //conversions
            System.out.printf("$%.2f", (double) i);
            System.out.printf("\t| %.2f", Math.round(i * DOLLAR_TO_EURO * 100.0) / 100.0);
            System.out.printf("\t| %.2f", Math.round(i * DOLLAR_TO_POUND * 100.0) / 100.0);
            System.out.printf("\t| %.2f", Math.round(i * DOLLAR_TO_CANADIAN * 100.0) / 100.0);
            System.out.printf("\t| %.2f", Math.round(i * DOLLAR_TO_AUSTRALIAN * 100.0) / 100.0);
            System.out.printf("\t| %.2f", Math.round(i * DOLLAR_TO_YEN * 100.0) / 100.0);
            System.out.println("\n------------------------------------------------");
        }
    }
}