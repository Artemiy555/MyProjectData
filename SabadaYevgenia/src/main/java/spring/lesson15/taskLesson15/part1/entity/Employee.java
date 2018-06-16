package spring.lesson15.taskLesson15.part1.entity;

public class Employee {

    private Director director;
    private Driver driver;
    private Manager manager;

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    @Override
    public String toString() {
        return "Employee{" +
                "director=" + director +
                ", driver=" + driver +
                ", manager=" + manager +
                '}';
    }
}
