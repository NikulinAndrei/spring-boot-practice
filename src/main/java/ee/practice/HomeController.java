package ee.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/2/2016.
 */
@Controller
public class HomeController {
  private static final Logger log = LoggerFactory.getLogger(HomeController.class);
  @Value("${app.mode}")
  private String mode;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home( Model model){
    log.info("The mode is " + mode);
    model.addAttribute("mode", mode);
    return "index";
  }
}
