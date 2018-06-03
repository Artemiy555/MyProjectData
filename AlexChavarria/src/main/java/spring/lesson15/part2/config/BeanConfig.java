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
    @Description("Иван(менеджер средднего звена)")
    public Employee beanIvan() {
        return new Employee("Ivan","Manager",50.00);

    }

    @Bean(name = "Viktor")
    @Description("Виктор (водитель)")
    public Employee beanViktor(){
        return new Employee("Viktor","Driver",75.00);
    }

    @Bean
    public Company beanOriflame(){
        return new Company("Oriflame");
    }

    @Bean
    public List<Employee> employees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(beanIvan());
        employees.add(beanViktor());
        return employees;
    }

    @Bean(name = "Maybah")
    public Car beanMaybah(){
        return new Car("Maybah",2018);
    }

    @Bean(name = "Ferrary")
    public Car beanFerrary(){
        return new Car("Ferrary",2018);
    }


}
