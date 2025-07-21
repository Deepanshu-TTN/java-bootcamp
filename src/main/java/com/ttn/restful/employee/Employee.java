package com.ttn.restful.employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Employee {

    private Integer id;

    @Size(min=3, message = "Name should be at least 3 characters.")
    private String name;

    @Min(value = 21, message = "Age must be more than 21.")
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
