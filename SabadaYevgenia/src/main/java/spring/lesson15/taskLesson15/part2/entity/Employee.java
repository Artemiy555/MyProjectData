package spring.lesson15.taskLesson15.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    @Autowired
    private Driver driver;
    @Autowired
    private Manager manager;
    @Autowired
    private Director director;

    public Employee() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "driver=" + driver +
                ", manager=" + manager +
                ", director=" + director +
                '}';
    }
}
