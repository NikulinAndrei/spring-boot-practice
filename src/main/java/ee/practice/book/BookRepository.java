package ee.practice.book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/26/2016.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

  @Query("from Book b order by b.id desc")
  List<Book> findAll();

}
