package spring.lesson16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson16.service.RobotService;

import java.util.Calendar;

public class Lesson16Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/lesson16/main-config.xml");

        RobotService service = context.getBean(RobotService.class);

        service.create("Deviant01",Calendar.getInstance().getTime(), 8000.00);
        service.create("Deviant02", Calendar.getInstance().getTime(), 9000.00);
    }
}

