package spring.lesson15.taskLesson15.part2.entity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class Company {
    private String title;
    @Autowired
    private List<Employee>employees;

    public Company(String title) { this.title = title; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Company{" +
                "title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }
}
