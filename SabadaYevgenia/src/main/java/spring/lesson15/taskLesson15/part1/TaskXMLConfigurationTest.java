package spring.lesson15.taskLesson15.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson15.taskLesson15.part1.entity.Company;

public class TaskXMLConfigurationTest {

    public static void main(String[] args) {

        ApplicationContext context=
                new ClassPathXmlApplicationContext(new String[]{"spring/lesson15/taskSpring-config.xml"});

        Company company=context.getBean("Faberlic", Company.class);
        System.out.println(company);


    }
}
