package assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Question4 {
    public static void main(String[] args) {
        Map<Employe, Double> employeSalaryMap = new HashMap<>();
        employeSalaryMap.put(new Employe(21, "Senior", "Chinto"), 12_000_000.0);
        employeSalaryMap.put(new Employe(28, "MegaJunior", "Deepanshu"), 32_000.0);
        employeSalaryMap.put(new Employe(28, "MegaJunior", "Deepanshu"), 32_000.0);
        System.out.println(employeSalaryMap);
    }
}

class Employe {
    Double age; String designation; String name;

    Employe(double age, String designation, String name) {
        this.age = age;
        this.designation = designation;
        this.name = name;
    }

    @Override
    public String toString() {
        return "employee{" + name + ", " + age + ", " + designation + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(age, employe.age) &&
                Objects.equals(designation, employe.designation) &&
                Objects.equals(name, employe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, designation, name);
    }
}