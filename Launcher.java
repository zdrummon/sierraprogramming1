// Launcher.java

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.lang.reflect.Method;


public class Launcher {
    public static void main(String[] args) {

        //user input to select a program to run
        int projChoice = 0;
        
        //using the imported File class to make a list of files
        File root = new File("."); //local file as object root
        File[] children = root.listFiles(); //return an array of files in root

        //using the imported List, ArrayList, and Collections classes to make a list of the project folders
        List<String> entries = new ArrayList<>();
        if (children != null) {
            for (File child : children) { //loop across the array of files in root (child is the current value)
                if (child.isDirectory()) { //returns true if the file is a directory
                    String name = child.getName();
                    if (name.startsWith("proj_")) { //excludes folders like .vscode
                        entries.add(name);
                    }
                }
            }
            Collections.sort(entries); //filtered file list in order since File can return in any order
        }

        //parse the folder names to get the labels and display them to the user
        System.out.println("Choose a program to run fom the list:\n0. Exit");

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i); //get the folder name from the Collections list
            String[] parts = entry.split("_", 3); //split the folder name into label.parts[]
            String label = parts[2]; //this is the folder name minus proj and the number
            System.out.println((i + 1) + ". " + label);
        }

        //using the imported Scanner class to get user input
        System.out.print("Enter the number below to run a program: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        if (input.isEmpty() || input.equals("0")) {
            //handling empty input or exit command
        } else {
            //parse the input to an integer
            projChoice = Integer.parseInt(input);
        }

        scanner.close(); //always gotta remember to close this lol

        if (projChoice == 0) {
            System.out.println("Exiting.");

        //if the user input is a valid number, launch the program
        } else if (projChoice > 0 && projChoice <= entries.size()) {
            //parse the file names from entries again, but this time to populate the className for reflection
            String folderName = entries.get(projChoice - 1);
            String[] parts = folderName.split("_", 3);
            String label = parts[2];
            String className = folderName + "." + label;
            System.out.println(label + " launching...\n\n");

            // reflection call goes here, using className
            try {
                //using the imported reflection Method class, I barely understand this because AI helped me
                Class<?> clazz = Class.forName(className);//fetches the class object from the parsed className
                Method mainMethod = clazz.getMethod("main", String[].class); //finds the method with that name and parameter type (because overloading) and puts it in mainMethod
                mainMethod.invoke(null, (Object) new String[0]); //this invokes the method we found, passing null as the arg, invoking mainMethod (the main method in the targeted class) runs the next program

            } catch (Exception e) {
                System.out.println("Couldn't launch " + className + ": " + e.getMessage());
            }

        } else {
            System.out.println("Unknown command, closing launcher.");
        }


    }
}
