package ee.practice.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 6/1/2016.
 */
@MappedSuperclass @Audited
public abstract class AbstractEntity {

  @Version
  @Getter @Setter private int version;

  @Column(name = "created_at", updatable = false)
  @CreationTimestamp
  @Getter @Setter private Date createdAt;

  @Column(name = "modified_at", insertable = false)
  @UpdateTimestamp
  @Getter @Setter private Date modifiedAt;


}
