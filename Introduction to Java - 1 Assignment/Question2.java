import java.util.Scanner;

/** Write a program to read user input until user writes XDONE and then show the entered text by the user on command line*/
public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            System.out.print("Enter text: ");
            String input = scanner.nextLine();
            if (input.equals("XDONE")) {
                System.out.println(sb);
                break;
            }
            sb.append(input);
        }
        scanner.close();
    }
}