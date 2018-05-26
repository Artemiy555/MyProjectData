package spring.lesson15.part2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import spring.lesson15.part2.entity.Company;
import spring.lesson15.part2.entity.Employee;

@Configuration
public class BeanConfig {

    @Bean
    @Description("Иван (менджер среднего звена)")
    public Employee beanIvan() {
        return new Employee(
                "Ivan",
                "Manager",
                50.00
        );
    }

    @Bean
    @Description("Виктор (водитель)")
    public Employee beanViсtor() {
        return new Employee(
                "Victor",
                "Driver",
                75.00
        );
    }

    @Bean
    public Company beanOriflame() {
        return new Company("Oriflame");
    }


}
