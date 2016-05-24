package ee.practice;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/6/2016.
 */
@XmlRootElement
public class User {
  private int id;

  public User() { }
  User(int id) {
    this.id = id;
  }

  @XmlAttribute
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
