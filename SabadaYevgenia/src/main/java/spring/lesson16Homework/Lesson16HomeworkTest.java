package spring.lesson16Homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson16Homework.service.ClientService;

public class Lesson16HomeworkTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("spring/lesson16Homework/main-config.xml");
        ClientService service = context.getBean(ClientService.class);
        service.create("Sokolov","0971282044",
                "mkas@mail.ri","50%");
        service.create("Ivaniv","0971283344",
                "mkas@zssmail.ri","70%");
    }
}
