// Launcher.java
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.reflect.Method;


public class Launcher {
    public static void main(String[] args) {

        int projChoice = 0;
        
        File root = new File(".");
        File[] children = root.listFiles();

        List<String> entries = new ArrayList<>();
        if (children != null) {
            for (File child : children) {
                if (child.isDirectory()) {
                    String name = child.getName();
                    if (name.startsWith("proj_")) {
                        entries.add(name);
                    }
                }
            }
        }

        Collections.sort(entries);

        System.out.println("Choose a program to run fom the list:\n0. Exit");

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split("_", 3);
            String label = parts[2];
            System.out.println((i + 1) + ". " + label);
        }

        System.out.print("Enter the number below to run a program:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        if (input.isEmpty() || input.equals("0")) {
            // default behavior
        } else {
        // handle the actual value
            try {
                projChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Exiting.");
            }
        }

        scanner.close();

        if (projChoice == 0) {
            System.out.println("Exiting.");

        } else if (projChoice > 0 && projChoice <= entries.size()) {
            String folderName = entries.get(projChoice - 1);
            String[] parts = folderName.split("_", 3);
            String label = parts[2];
            String className = folderName + "." + label;
            System.out.println(label + " launching...\n\n");

            // reflection call goes here, using className
            try {
                Class<?> clazz = Class.forName(className);
                Method mainMethod = clazz.getMethod("main", String[].class);
                mainMethod.invoke(null, (Object) new String[0]);

            } catch (Exception e) {
                System.out.println("Couldn't launch " + className + ": " + e.getMessage());
            }

        } else {
            System.out.println("Unknown command, closing launcher.");
        }


    }
}
