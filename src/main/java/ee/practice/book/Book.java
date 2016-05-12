package ee.practice.book;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
public class Book {
  private int id;
  private String title;
  private String author;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
