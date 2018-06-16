package spring.lesson15.taskLesson15.part1.entity;

public class Manager {
    private String name;
    private String surname;
    private Double salary;

    public Manager(String name, String surname, Double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
