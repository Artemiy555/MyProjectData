package spring.lesson15.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson15.part2.config.BeanConfig;
import spring.lesson15.part2.entity.Company;
import spring.lesson15.part2.entity.Employee;

public class AnnotationsConfiguratoinTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        Company company = context.getBean(Company.class);
        System.out.println(company);

        Employee employee = context.getBean("Ivan", Employee.class);
        System.out.println(employee);
    }
}