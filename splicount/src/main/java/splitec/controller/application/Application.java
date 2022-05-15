package splitec.controller.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import splitec.controller.UsuarioController;

@SpringBootApplication
public class Application extends UsuarioController {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
