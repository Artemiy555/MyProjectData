package spring.lesson15.taskLesson15.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

import spring.lesson15.taskLesson15.part2.entity.*;

import java.security.spec.ECFieldF2m;
import java.util.ArrayList;
import java.util.List;

public class BeanConfig {

    @Bean(name = "Ivan")
    @Description("Иван (менджер среднего звена)")
    public Employee beanEmployee(){
        return  new Employee();
    }


    @Bean
    @Description("Иван (менджер среднего звена)")
    public Manager beanIvan(){
        return  new Manager("Ivan","Sokolov", 5000.00);
    }

    @Bean(name = "Alexey")
    @Description("Алексей (водитель)")
    public Driver beanAlexey(){
        return new Driver("Alexey", "Shevchuk",2000.00,"Porch");
    }

    @Bean(name = "Vova")
    @Description("Вова (директор)")
    public Director beanVova(){
        return new Director("Vova","Kolesnyk",100000.00);
    }

//    @Bean
//    public List<Employee> employees() {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(beanVova());
//        employees.add(beanAlexey());
//        employees.add(beanIvan());
//        return employees;
//    }

        @Bean
       public Company beanFaberlic() {
            return  new Company("Faberlic");
        }



}
