package assignment;

public class Question5 {
    public static void main(String[] args) {
        DatabaseConnector connector1 = DatabaseConnector.getConnection();
        DatabaseConnector connector2 = DatabaseConnector.getConnection();

        connector1.queryOrSomething();
        connector2.queryOrSomething();

        if (connector1 == connector2) {
            System.out.println("Both connectors are the same instance");
        } else {
            System.out.println("different instances");
        }
    }
}

class DatabaseConnector{
    private static DatabaseConnector instance;

    private DatabaseConnector(){};

    public static DatabaseConnector getConnection(){
        if(instance==null){
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public void queryOrSomething(){
        System.out.println("Querying database...");
    }
}