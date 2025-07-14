import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scratch {
    public static void main(String[] args) {
        /**/
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 101, 75000.0, "HR"),
                new Employee("Bob", 102, 85000.0, "Finance"),
                new Employee("Charlie", 103, 65000.0, "IT"),
                new Employee("Diana", 104, 92000.0, "Finance"),
                new Employee("Evan", 105, 58000.0, "HR"),
                new Employee("Fay", 106, 75000.0, "IT")
        );
        // avg salary
        System.out.println("\nAverage salary");
        System.out.println(employees.stream().collect(Collectors.averagingDouble(e->e.salary)));

        // employee with max salary
        System.out.println("\nEmployee with max salary");
        System.out.println(employees.stream().max(Comparator.comparingDouble(e -> e.salary)));

        // employee with min salary
        System.out.println("\nEmployee with Min salary");
        System.out.println(employees.stream().min((Comparator.comparingDouble(e->e.salary))));
        /*
        employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.counting()
                )).forEach((dept, count) -> {
                    System.out.println(dept + ": " + count);
                });

        employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.mapping(e -> e.name, Collectors.toList())
                )).forEach((dept, lis)-> System.out.println(dept+": "+lis));
        */

        List<Integer> list = Arrays.asList(11,24,2,7,14,90,12,5,1,2,2, 200,11, 29);

        // cumulative sum
        System.out.println(list.stream().reduce(0,Integer::sum));

        // even numbers in order
        System.out.println(list.stream().distinct().sorted().filter(i->i%2==0).toList());

        // print numbers prefixed with 2
        System.out.println(
                list.stream().distinct().map(Object::toString).filter(e->e.startsWith("2")).toList()); //TODO ask why object tostring give strings
        //same as
//        System.out.println(
//                list.stream().distinct().map(String::valueOf).filter(e->e.startsWith("2")).toList());

        // find duplicates and counts
        System.out.println(
                list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                        .entrySet().stream().filter(e->e.getValue()>1).toList());

        // or by this
        Set<Integer> freq = new HashSet<>();
        System.out.println("------------------");
        System.out.println(list.stream().filter(e -> !freq.add(e)).distinct().toList());

        // max value
        System.out.println(list.stream().max(Comparator.comparingInt(Integer::valueOf)));
        //min value
        System.out.println(list.stream().min(Comparator.comparingInt(e->e)));

        // print all nums ignoring first 5
        System.out.println(list.stream().skip(5).toList());

        // print second highest
        System.out.println(list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst());


//        List<List<Integer>> list = Arrays.asList(
//                Arrays.asList(1,2,3,4),
//                Arrays.asList(5,6,7),
//                Arrays.asList(8,9)
//        );
//        List<Integer> newList = list.stream().flatMap(Collection::stream).toList();

        String sentence = "java stream api makes coding easier";
        Character maxOccuredChar = sentence.replaceAll(" ", "").chars().mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(e->e, Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
        System.out.println(maxOccuredChar);
    }
}

class Employee {
    String name;
    int id;
    double salary;
    String dept;

    public Employee(String name, int id, double salary, String dept) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}