package ee.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;

/**
 * Hello world!
 */
@SpringBootApplication
@PropertySource("file:/opt/conf/practice.properties")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer(){
    return (container -> {
      System.out.println("Configuring error pages");
      ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
      ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

      container.addErrorPages(error404Page, error500Page);
    });
  }

}
