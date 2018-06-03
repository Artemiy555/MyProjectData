package spring.lesson15.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson15.part2.config.BeanConfig;
import spring.lesson15.part2.entity.Company;
import spring.lesson15.part2.entity.Employee;

public class AnnotationsConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(BeanConfig.class);
        configApplicationContext.refresh();

        Company company = configApplicationContext.getBean(Company.class);
        System.out.println(company);

        Employee employee = configApplicationContext.getBean("Ivan", Employee.class);
        System.out.println(employee);
    }
}
