package ee.practice.book;

import ee.practice.ex.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Service
class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  int insert(Book book){
    bookRepository.save(book);
    return book.getId();
  }

  public Optional<Book> load(int id) {
    return Optional.ofNullable( bookRepository.findOne(id) );
  }

  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  public Page<Book> list(int pageNr) {
    return bookRepository.findAll(
        new PageRequest( pageNr, 5, new Sort(Sort.Direction.DESC, "id"))
    );
  }


  public void update(Book book) {
    if(!bookRepository.exists(book.getId()))
      throw new NotFoundException( "Book Not found ");
    bookRepository.save( book );
  }
}
