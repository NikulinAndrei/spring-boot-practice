package ee.practice;

import ee.practice.ex.NotFoundException;
import ee.practice.user.User;
import ee.practice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/6/2016.
 */
@RestController
public class RestServiceController {

  @Autowired UserService userService;

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable int id ) {
    return userService.loadById( id ).
        orElseThrow( ()-> new NotFoundException("No user with id="+id) );
  }
}