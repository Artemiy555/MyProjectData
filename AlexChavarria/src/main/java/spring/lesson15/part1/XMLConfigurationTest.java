package spring.lesson15.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson15.part1.entity.Human;
import spring.lesson15.part1.entity.Weapon;

public class XMLConfigurationTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/lesson15/spring-config.xml"});

        Human human = context.getBean("Ivan", Human.class);
        System.out.println(human);

        Human human1 = context.getBean("Vasya", Human.class);
        System.out.println(human1);

        Human tannos = context.getBean("Tannos", Human.class);
        System.out.println(tannos);

        Weapon axe = context.getBean("Axe", Weapon.class);
        System.out.println(axe);

        Weapon dagger = context.getBean("Dagger", Weapon.class);
        System.out.println(dagger);

        Weapon cricket = context.getBean("beamGun", Weapon.class);
        System.out.println(cricket);
    }

}
