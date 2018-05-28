package spring.lesson15.part2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import spring.lesson15.part2.entity.Car;
import spring.lesson15.part2.entity.Company;
import spring.lesson15.part2.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean(name = "Ivan")
    @Description("Иван (менджер среднего звена)")
    public Employee beanIvan() {
        return new Employee(
                "Ivan",
                "Manager",
                50.00
        );
    }

    @Bean(name = "Victor")
    @Description("Виктор (водитель)")
    public Employee beanViсtor() {
        return new Employee(
                "Victor",
                "Driver",
                75.00
        );
    }

    @Bean(name = "Maybach")
    public Car beanMaybach() {
        return new Car("Maybach", 2018);
    }

    @Bean(name = "Ferrari")
    public Car beanFerrari() {
        return new Car("Ferrari", 2018);
    }

    @Bean
    public List<Employee> employees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(beanIvan());
        employees.add(beanViсtor());
        return employees;
    }

    @Bean
    public Company beanOriflame() {
        return new Company("Oriflame");
    }


}
