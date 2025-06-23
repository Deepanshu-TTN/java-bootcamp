import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { //doubt - finally close automatically, scanner scoped inside try
            System.out.println("Try block");
            System.out.print("Enter numerator: ");
            int numerator = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter denominator: ");
            int denominator = Integer.parseInt(scanner.nextLine());

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Catch Block divide by 0");
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Catch Block invalid input");
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program has ended (finally block executed).");
        }
    }
}
