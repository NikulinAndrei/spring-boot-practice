package ee.practice.book;

import javax.persistence.*;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Entity
public class Book {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(name = "nr_of_pages")
  private int nrOfPages;

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", nrOfPages=" + nrOfPages +
        '}';
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getNrOfPages() {
    return nrOfPages;
  }

  public void setNrOfPages(int nrOfPages) {
    this.nrOfPages = nrOfPages;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
