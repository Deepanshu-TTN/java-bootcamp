import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Scratch {

    public static void main(String[] args) {
        Map<User, String> newMap = new HashMap<>();
        User user = new User(20000, "Deepanshu");
        newMap.put(user, "some value");
        System.out.println(newMap);
        user.setSalary(50000);
        System.out.println(newMap);
        // null if salary is used in hashcode
        System.out.println(newMap.get(user));

    }
}
class User {
    int salary;
    String name;

    public User(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        //since we plan on changing salary later we have to exclude it from equals and hashCode logic
//        return salary == user.salary && Objects.equals(name, user.name);
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hash called");
        //since we plan on changing salary later we have to exclude it from equals and hashCode logic
//        return Objects.hash(salary, name);
        return Objects.hash(name);
    }

}