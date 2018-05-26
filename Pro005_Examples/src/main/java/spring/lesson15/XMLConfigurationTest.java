package spring.lesson15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson15.entity.Human;
import spring.lesson15.entity.Weapon;

public class XMLConfigurationTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[] { "spring/lesson15/spring-config.xml" });

        Human human = context.getBean("Ivan", Human.class);
        System.out.println(human);

        Human human1 = context.getBean("Vasya", Human.class);
        System.out.println(human1);

        Weapon axe = context.getBean("Axe", Weapon.class);
        System.out.println(axe);
        Weapon knife = context.getBean("LegendaryOfficeKnife", Weapon.class);
        System.out.println(knife);
    }
}
