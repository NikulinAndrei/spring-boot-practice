package ee.practice.book;

import org.codehaus.groovy.runtime.metaclass.ConcurrentReaderHashMap;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Service
public class BookService {
  private AtomicInteger ids = new AtomicInteger(0);
  private Map<Integer, Book> books = new HashMap<>();

  public BookService() {
    Book b = new Book();
    b.setTitle("Some");
    b.setAuthor("Agnija Barto");
    b.setNrOfPages(15);
    insert(b);
  }

  int insert(Book book){
    int id = ids.incrementAndGet();
    book.setId(id);
    books.put(id, book);
    return id;
  }

  public Optional<Book> load(int id) {
    return Optional.ofNullable(books.get(id));
  }

  public List<Book> getAll() {
    return books.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getKey))
        .map( Map.Entry::getValue)
        .collect(Collectors.toList());
  }

  public void update(Book book) {
    if(!books.containsKey( book.getId()))
      throw new RuntimeException( "Book Not found ");
    books.put( book.getId(), book);
  }
}
