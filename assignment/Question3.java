package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question3 {
    public static void main(String[] args) {
        String file = args[0];
        String search = args[1];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (true) {
                String line = reader.readLine();
                if (line == null)break;
                String[] words = line.toLowerCase().split(" ");

                for (String word : words) {
                    if (word.equals(search)) {
                        count++;
                    }
                }
            }
            System.out.println(search + " found " + count + " times");
        } catch (FileNotFoundException e) {
            System.out.println("File no exist.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
