package com.ttn;

import com.ttn.assignment.Employee;
import com.ttn.assignment.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;;

@ComponentScan
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

        NotificationService n = applicationContext.getBean(NotificationService.class);
        Employee e = applicationContext.getBean(Employee.class);

        n.send("Hello " + e.getName());
    }
}
