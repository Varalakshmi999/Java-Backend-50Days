package com.employee;

public class Employee {
    private int id;
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
}
