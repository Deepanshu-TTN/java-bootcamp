import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius;
        while (true){
            printMenu();
            switch (scanner.nextInt()){
                case 1:
                    System.out.print("Enter radius: ");
                    radius = scanner.nextDouble();
                    System.out.println("Area of the circle is: " + getCircleArea(radius));
                    break;
                case 2:
                    System.out.print("Enter radius: ");
                    radius = scanner.nextDouble();;
                    System.out.println("Circumfernce of the circle is: " + getCircleCircumference(radius));
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input try again.");
            }
        }
    }

    private static double getCircleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    private static double getCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    private static void printMenu() {
        System.out.println("*******Menu*******");
        System.out.println(" 1. Calculate Area of Circle");
        System.out.println(" 2. Calculate Circumference of a Circle");
        System.out.print(" 3. Exit. Choose an option (1-3): ");

    }
}