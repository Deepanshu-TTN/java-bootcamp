package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question2 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(21.0, 15000.0, "Deepanshu Mishra"));
        employees.add(new Employee(22.0, 17210.0, "Deepanshu Mishra"));
        employees.add(new Employee(26.0, 290091.0, "Deepanshu Mishra"));
        employees.add(new Employee(20.0, 18531.0, "Deepanshu Mishra"));
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
}