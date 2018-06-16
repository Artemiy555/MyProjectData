package spring.lesson15.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson15.part1.entity.Human;
import spring.lesson15.part1.entity.Wearpon;

public class XMLConfigurationTest {
    public static void main(String[] args) {

        ApplicationContext context=
                new ClassPathXmlApplicationContext(new String[]{"spring/lesson15/spring-config.xml"});

        Human human = context.getBean("Ivan",Human.class);
        System.out.println(human);

        Human human1 = context.getBean("Vasya",Human.class);
        System.out.println(human1);

        Wearpon axe = context.getBean("Axe",Wearpon.class);
        System.out.println(axe);

        Wearpon knife = context.getBean("LegendaryOfficeKnife",Wearpon.class);
        System.out.println(knife);

    }
}
