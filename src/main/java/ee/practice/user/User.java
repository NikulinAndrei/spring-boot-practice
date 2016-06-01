package ee.practice.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/6/2016.
 */
@XmlRootElement
@JsonIgnoreProperties({"pwd"})
@Entity @Table(name = "app_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  @Getter @Setter  private String name;

  @Column
  @Setter private String pwd;

  @Column
  @Getter @Setter private String username;

  public User() { }
  public User(int id) {
    this.id = id;
  }

  @XmlTransient
  public String getPwd() {
    return pwd;
  }
}