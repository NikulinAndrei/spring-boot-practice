package ee.practice.book;

import ee.practice.ex.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Service @Transactional
@Slf4j
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

  Optional<Book> load(int id) {
    return Optional.ofNullable( bookRepository.findOne(id) );
  }

  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  Page<Book> list(int pageNr) {
    return bookRepository.findAll(
        new PageRequest( pageNr, 5, new Sort(Sort.Direction.DESC, "id"))
    );
  }


  Book update(Book book) {
    log.info("Updating book {}", book.getId());
    Book existing = load( book.getId())
        .orElseThrow(()->new NotFoundException( "Book Not found "));
    copyBookData( book, existing);
    bookRepository.save( existing );
    return existing;
  }

  void delete(int id){
    log.info("deleting book {}", id);
    bookRepository.delete( id );
  }

  private void copyBookData(Book src, Book target) {
    target.setTitle( src.getTitle());
    target.setAuthor( src.getAuthor());
    target.setNrOfPages( src.getNrOfPages());
  }

}
