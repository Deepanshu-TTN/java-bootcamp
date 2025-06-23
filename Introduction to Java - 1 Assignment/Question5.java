class Employee {
    public enum Designation {
        MANAGER,
        DEVELOPER,
        TESTER,
        ANALYST,
        INTERN
    }

    private String _firstname;
    private String _lastname;
    private int _age;
    private Designation _designation;

    public Employee() {
        setFirstname("Unknown")
                .setLastname("Unknown")
                .setAge(0)
                .setDesignation(Designation.INTERN);
    }

    public Employee(String firstname, String lastname, int age, Designation designation) {
        setFirstname(firstname)
                .setLastname(lastname)
                .setAge(age)
                .setDesignation(designation);
    }

    public Employee(String firstname, String lastname) {
        setFirstname(firstname)
                .setLastname(lastname)
                .setAge(0)
                .setDesignation(Designation.INTERN);
    }

    public String getFirstname() {
        return _firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    public int getAge() {
        return _age;
    }

    public Designation getDesignation() {
        return _designation;
    }

    public Employee setFirstname(String firstname) {
        _firstname = firstname;
        return this;
    }

    public Employee setLastname(String lastname) {
        _lastname = lastname;
        return this;
    }

    public Employee setAge(int age) {
        _age = age;
        return this;
    }

    public Employee setDesignation(Designation designation) {
        _designation = designation;
        return this;
    }

    @Override
    public String toString() {
        return "Employee Details: " +
                "First Name = " + getFirstname() +
                ", Last Name = " + getLastname() +
                ", Age = " + getAge() +
                ", Designation = " + getDesignation();
    }
}

public class Question5 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Deepanshu", "Mishra");
        Employee e3 = new Employee("Chinto", "Chib", 24, Employee.Designation.TESTER);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}