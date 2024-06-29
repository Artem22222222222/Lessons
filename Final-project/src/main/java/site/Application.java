package site;
import DataBases.CreateTables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new CreateTables();
        SpringApplication.run(Application.class, args);
    }
}