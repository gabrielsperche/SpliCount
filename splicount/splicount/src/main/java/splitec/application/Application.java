package splitec.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import splitec.controller.Controller;

@SpringBootApplication
public class Application extends Controller {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
