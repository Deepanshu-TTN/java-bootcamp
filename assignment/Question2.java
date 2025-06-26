package assignment;

@FunctionalInterface
interface MathOperation {
    int operate(int p, int q);
}

class MathUtil {
    public int applyAdd(int a, int b){return a + b;}
    public int applySubtract(int a, int b){return a - b;}

    public static int applyMultiply(int a, int b){return a * b;}

}

public class Question2 {
    public static void main(String[] args) {
        MathUtil uti = new MathUtil();

        MathOperation addition = uti::applyAdd;
        System.out.println(19 + " + " + 58 + " = " + addition.operate(19,58));

        MathOperation subtraction = uti::applySubtract;
        System.out.println(19 + " - " + 58 + " = " + subtraction.operate(19,58));

        MathOperation multiplication = MathUtil::applyMultiply;
        System.out.println(19 + " * " + 58 + " = " + multiplication.operate(19,58));

    }
}

