package com.netcracker.Employee;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }
    public String getName() {
        return firstName + " "+ lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAnnualSalary(){
        return 12*salary;
    }
    public int raiseSalary(int percent) {
        salary += salary*percent;
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode += 31*hashcode + firstName.hashCode();
        hashcode += 31*hashcode + lastName.hashCode();
        hashcode += 31*hashcode + id;
        hashcode += 31*hashcode + salary;

        return hashcode;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", Name=" +firstName + " "+ lastName +
                ", salary=" + salary +
                ']';
    }
}
