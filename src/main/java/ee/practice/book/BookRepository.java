package ee.practice.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/26/2016.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

  @Query("from Book b order by b.id desc")
  List<Book> findAll();

}
