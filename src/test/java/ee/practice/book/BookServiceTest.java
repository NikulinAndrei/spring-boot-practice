package ee.practice.book;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/18/2016.
 */
public class BookServiceTest {
  BookService service = new BookService( null );

  @Test
  public void insert() throws Exception {

    int id = service.insert( new Book());
    assertThat(id, is(2));
  }

}