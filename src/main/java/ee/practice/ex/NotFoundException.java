package ee.practice.ex;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/12/2016.
 *
 * When some resource cannot be found
 */
public class NotFoundException extends  AppException{

  public NotFoundException(String msg) {
    super(msg);
  }
}
