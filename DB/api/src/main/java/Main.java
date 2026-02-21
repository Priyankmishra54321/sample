import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.logic","com.org","api"})
public class Main {

    @PostConstruct
    public void init() {
        System.out.println("Application started successfully");
        com.org.hello hello=new com.org.hello();
        hello.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
