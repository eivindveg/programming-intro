package haas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HelloAsAServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloAsAServiceApplication.class, args);
    }

}
