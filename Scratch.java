import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    int id; String name; double netWorth;
    Employee(int id, String name, double netWorth){
        this.id = id;
        this.name = name;
        this.netWorth = netWorth;
    }

    void upWorth(double e){
        this.netWorth *= e;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id +
                ", name='" + name + '\'' +
                ", netWorth=" + netWorth +
                '}';
    }
}

public class Scratch {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(arrayOfEmps);
        int[] ids = {1,2,3};

        employeeList.stream().forEach(e -> e.upWorth(1.5));

        System.out.println(Stream.of(Arrays.asList(ids)).count());
        System.out.println(Stream.of(Arrays.asList(ids)).collect(Collectors.counting()));




        Supplier<Stream> streamSupplier = ()->employeeList.stream().map(e->e.netWorth++).filter(e->e%2==0);
        System.out.println(Arrays.asList(arrayOfEmps));
        System.out.println(employeeList);
    }
}