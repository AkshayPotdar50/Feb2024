package dsa.sorting.pract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Replace "example.txt" with the actual file path
        String filePath = "example.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Code to read from the file goes here
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle exceptions, if any
            e.printStackTrace();
        }
        // No need to explicitly close the resource; it's done automatically.
    }
}
