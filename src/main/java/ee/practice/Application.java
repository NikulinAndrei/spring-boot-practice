package ee.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 */
@SpringBootApplication
@PropertySource("file:/opt/conf/practice.properties")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
