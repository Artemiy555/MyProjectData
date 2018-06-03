package spring.lesson15.taskLesson15.part1.entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Company {
    private String title;
    private Employee employees;

    public Company(String title, Employee employees) {
        this.title = title;
        this.employees = employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    @Override
    public String toString() {
        return "Company{" +
                "title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }
}
