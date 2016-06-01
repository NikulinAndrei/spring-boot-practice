package ee.practice.book;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Entity @Data
public class Book {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(name = "nr_of_pages")
  private int nrOfPages;
}