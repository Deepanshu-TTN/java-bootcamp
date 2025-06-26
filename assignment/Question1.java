package assignment;

public class Question1 {
    public static void main(String[] args) {
        StringUpper stringss = (s) -> s.toUpperCase();
        System.out.println(stringss.toUpper("thisissolow"));

        StringConcat strings = (s1, s2) -> s1+s2;
        System.out.println(strings.concat("Deepanshu", "Misra"));

        IncrementOperation operation = (x) -> x++;
        System.out.println(operation.incrementByOne(29));

        NumberComparator compare = (a, b) -> a > b;
        System.out.println(compare.isFirstGreaterThanSecond(5,1));
        System.out.println(compare.isFirstGreaterThanSecond(4,5));
    }
}

/** To check whether the first number is greater than second number or not,
 * Parameter (int ,int ) Return type boolean */
@FunctionalInterface
interface NumberComparator{
    boolean isFirstGreaterThanSecond(int x, int y);
}

/** Increment the number by 1 and return incremented value Parameter (int) Return int */
@FunctionalInterface
interface IncrementOperation{
    int incrementByOne(int x);
}

/** Concatination of 2 string Parameter (String , String ) Return (String) */
@FunctionalInterface
interface StringConcat{
    String concat(String str1, String str2);
}

/** Convert a string to uppercase and return . Parameter (String) Return (String)*/
@FunctionalInterface
interface StringUpper {
    String toUpper(String str);
}
