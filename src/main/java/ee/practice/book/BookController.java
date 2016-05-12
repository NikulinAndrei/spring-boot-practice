package ee.practice.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Controller
public class BookController {
  private static final Logger log = LoggerFactory.getLogger(BookController.class);

  @Autowired BookService service;

  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public String list(Model model){
    model.addAttribute("books", service.getAll());
    return "book/list";
  }

  @RequestMapping(value = "/book", method = RequestMethod.GET)
  public String newBook(Model model){
    model.addAttribute("book", new Book());
    return "book/book";
  }

  @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
  public String newBook(@PathVariable int id,  Model model){
    log.info("Showing info for {}" + id);
    model.addAttribute("book", service.load(id));
    return "book/book";
  }

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  public String save(Book book, RedirectAttributes flash) {
    log.info("Saving {}", book );
    int id = service.insert( book );
    flash.addFlashAttribute("SUCCESS_MSG", "book saved");
    return "redirect:/books";
  }

}
