package mentoring.mvc;

import mentoring.mvc.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main
{
    // https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/?utm_source=mkyong&utm_medium=author&utm_campaign=related-post&utm_content=2
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Main.class, args);
    }
}
