package ee.practice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/6/2016.
 */
@RestController
public class RestServiceController {

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable int id ) {
    return new User(id);
  }

}
