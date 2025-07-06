package assignment;

public class Question3 {
    public static void main(String[] args) {
        Student s1 = new Student("S1", "Deepanshu", 11);
        Student s2 = new Student("S1", "Deepanshu", 11);
        System.out.println(s1.hashCode() + ", " + s2.hashCode());
        System.out.println(s1.equals(s2));
    }
}
