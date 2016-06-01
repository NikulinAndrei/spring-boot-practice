package ee.practice.book;

import ee.practice.ex.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Controller
@Slf4j
class BookController {

  @Autowired BookService service;

  @RequestMapping(value = {"/books/{pageNr}", "/books"}, method = RequestMethod.GET)
  public String list(@PathVariable Optional<Integer> pageNr,
                           Model model){
    int iPageNr = pageNr.orElse(0);
    Page<Book> page = service.list( iPageNr );

    model.addAttribute("books", page);
    return "book/list";
  }

  @RequestMapping(value = "/book", method = RequestMethod.GET)
  public String newBook(Model model){
    model.addAttribute("book", new Book());
    return "book/new";
  }

  @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
  public String newBook(@PathVariable int id,  Model model){
    log.info("Showing info for {}", id);
    Book book = service.load(id)
        .orElseThrow( ()-> new NotFoundException("Cannot load book for Id " + id));
    model.addAttribute("book", book);
    return "book/edit";
  }

  @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
  public String update(@PathVariable int id,  Book book, RedirectAttributes flash){
    log.info("Updating info for {}", book);
    service.update(book);
    flash.addFlashAttribute("SUCCESS_MSG", "book saved");
    return "redirect:/books";
  }

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  public String save(Book book, RedirectAttributes flash) {
    log.info("Inserting {}", book );
    service.insert( book );
    flash.addFlashAttribute("SUCCESS_MSG", "book saved");
    return "redirect:/books";
  }
}