package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question2<T> {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(21.0, 15000.0, "Deepanshu Mishra"));
        employees.add(new Employee(22.0, 17210.0, "Chinto CHib"));
        employees.add(new Employee(26.0, 290091.0, "Zander Kumar"));
        employees.add(new Employee(20.0, 18531.0, "Anjelin Jolly"));

        Collections.sort(employees);
        System.out.println("Sorted through natural ordering(name):");

        for(Employee employee: employees){
            System.out.println(employee);
        }

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -o1._salary.compareTo(o2._salary);
            }
        });
        System.out.println("\nSorted through salary:");
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }
}

class Employee implements Comparable<Employee>{
    Double _age; Double _salary; String _name;

    Employee(Double age, Double salary, String name) {
        _age = age;
        _salary = salary;
        _name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return _name.compareTo(o._name);
    }

    @Override
    public String toString() {
        return _name + ", " + _age + ", " + _salary;
    }
}