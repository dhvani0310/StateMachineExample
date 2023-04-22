import com.example.rfq.RfqStateMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.example.rfq")
public class RfqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RfqApplication.class, args);
    }
}
