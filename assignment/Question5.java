package assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question5 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Socrates the Wise", 4200L, "Delhi"),
                new Employee("Plato the Thinker", 6000L, "Athens"),
                new Employee("Aristotle the Mentor", 4800L, "Delhi"),
                new Employee("Alexander the Great", 3000L, "Delhi"),
                new Employee("Pericles the Orator", 5200L, "Sparta"),
                new Employee("Hippocrates the Healer", 4500L, "Kos"),
                new Employee("Pythagoras the Mystic", 4700L, "Delhi"),
                new Employee("Socrates the Teacher", 3900L, "Athens"),
                new Employee("Alexander of Macedonia", 3100L, "Delhi"),
                new Employee("Euclid the Mathematician", 4300L, "Alexandria"),
                new Employee("Homer the Poet", 3600L, "Delhi"),
                new Employee("Thales the Geometer", 4400L, "Miletus"),
                new Employee("Homer the Bard", 3800L, "Delhi"),
                new Employee("Zeno the Paradoxical", 5800L, "Delhi")
        );

        List<String> employeesFiltered = employees.stream()
                .filter(e->e.salary<5000L&& Objects.equals(e.city, "Delhi"))
                .map(e->e.fullName.split(" ")[0])
                .distinct()
                .toList();

        employeesFiltered.forEach(System.out::println);
    }
}

class Employee {
    String fullName;
    Long salary;
    String city;

    public Employee(String fullName, Long salary, String city) {
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }
}