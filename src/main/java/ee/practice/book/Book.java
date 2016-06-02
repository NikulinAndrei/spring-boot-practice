package ee.practice.book;

import ee.practice.common.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Entity
@SQLDelete( sql="UPDATE book SET is_deleted=true WHERE id = ? and version=?")
@Where(clause="is_deleted = 'false'")
@Data class Book extends AbstractEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(name = "nr_of_pages")
  private int nrOfPages;
}