// Homework1.java
package proj_3_Homework1;
import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {
        
        //init input scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put in your first name: ");
        String firstName = scanner.nextLine(); //scan input

        System.out.println("Put in your last name: ");
        String lastName = scanner.nextLine(); //scan input

        char first = Character.toUpperCase(firstName.charAt(0));
        char last;
        if (lastName.charAt(0) != firstName.charAt(0)) {
            last = Character.toUpperCase(lastName.charAt(0));
        } else {
            last = Character.toUpperCase(lastName.charAt(1));
        }
        
        System.out.println("=========================");
        System.out.println("=  your initials below  =");
        System.out.println("=========================");
        System.out.println("=                       =");
        System.out.println("=                       =");

        System.out.println("=        " + first + "     " + last + "        =");
        
        System.out.println("=                       =");
        System.out.println("=                       =");
        System.out.println("=========================");

        scanner.close(); //always gotta remember to close this lol
    }
}