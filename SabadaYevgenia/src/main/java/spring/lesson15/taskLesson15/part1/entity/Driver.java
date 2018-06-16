package spring.lesson15.taskLesson15.part1.entity;

public class Driver {
    private String name;
    private String surname;
    private Double salary;
    private String car;

    public Driver(String name, String surname, Double salary, String car) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.car = car;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public String getCar() { return car; }
    public void setCar(String car) { this.car = car; }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", car='" + car + '\'' +
                '}';
    }
}
