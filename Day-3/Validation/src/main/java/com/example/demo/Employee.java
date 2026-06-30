package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

    @Id
    private int id;

    @NotNull(message = "Name cannot be null")
    @Pattern(
        regexp = "^[a-zA-Z]*$",
        message = "Name must contain only characters"
    )
    private String name;


    @Max(
        value = 60,
        message = "Age cannot be more than 60"
    )
    @Min(
        value = 18,
        message = "Age cannot be less than 18"
    )
    private int age;


    private int salary;

    private String desig;


    public Employee() {
    }


    public Employee(int id, String name, int age, int salary, String desig) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.desig = desig;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getDesig() {
        return desig;
    }


    public void setDesig(String desig) {
        this.desig = desig;
    }
}