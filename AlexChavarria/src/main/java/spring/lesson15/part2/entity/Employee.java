package spring.lesson15.part2.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private String name;
    private String position;
    private Double slary;

    @Autowired
    @Qualifier("Maybah")
    private Car car;

    public Employee(String name, String position, Double slary) {
        this.name = name;
        this.position = position;
        this.slary = slary;
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public Double getSlary() {
        return slary;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", slary=" + slary +
                ", car=" + car +
                '}';
    }
}
