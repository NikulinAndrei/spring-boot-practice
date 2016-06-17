package ee.practice.book;

import ee.practice.common.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/11/2016.
 */
@Entity @Audited()
@SQLDelete( sql="UPDATE book SET is_deleted=true WHERE id = ? and version=?")
@Where(clause="is_deleted = 'false'")
@Data class Book extends AbstractEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  @NotNull @Size(min=3, max=100)
  private String title;

  @Column(nullable = false)
  @NotNull @Size(min=3, max=100)
  private String author;

  @Column(name = "nr_of_pages")
  @NotNull @Min(2) @Max(2000)
  private int nrOfPages;
}