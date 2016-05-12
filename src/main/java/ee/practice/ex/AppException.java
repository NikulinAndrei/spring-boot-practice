package ee.practice.ex;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/12/2016.
 */
public class AppException extends RuntimeException {
  public AppException(String msg) {
    super(msg);
  }

  public AppException(String msg, Throwable throwable) {
    super(msg, throwable);
  }
}
