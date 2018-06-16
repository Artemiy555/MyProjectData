package spring.lesson15.taskLesson15.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson15.taskLesson15.part2.config.BeanConfig;
import spring.lesson15.taskLesson15.part2.entity.Company;

public class TaskAnnotationsConfiguratoinTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        Company company = context.getBean(Company.class);
        System.out.println(company);

    }
}

