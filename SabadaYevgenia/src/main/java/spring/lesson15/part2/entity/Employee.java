package spring.lesson15.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private String name;
    private String position;
    private Double salary;

    @Autowired
    @Qualifier("Maybach")
    private Car car;

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Employee(String name, String position, Double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getPosition() { return position; }
    public Double getSalary() { return salary; }
    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
    public void setSalary(Double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
