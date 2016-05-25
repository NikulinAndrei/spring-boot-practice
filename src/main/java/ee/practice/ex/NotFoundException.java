package ee.practice.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/12/2016.
 *
 * When some resource cannot be found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends  AppException{

  public NotFoundException(String msg) {
    super(msg);
  }
}
