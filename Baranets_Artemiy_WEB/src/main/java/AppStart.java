import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("web")
public class AppStart {

    public static void main(String[] args) {
        try{
            SpringApplication.run(AppStart.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
