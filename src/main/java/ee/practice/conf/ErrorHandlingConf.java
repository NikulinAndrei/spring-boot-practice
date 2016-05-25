package ee.practice.conf;

import ee.practice.ex.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/12/2016.
 */
@ControllerAdvice
public class ErrorHandlingConf {
  private static final Logger log = LoggerFactory.getLogger(ErrorHandlingConf.class);

  @ExceptionHandler(Throwable.class)
  public void unhandled(Throwable e) throws Throwable {
    log.error("Unhandled exception :" + e.getMessage(), e);
    throw e;
  }

  @ExceptionHandler(NotFoundException.class)
  public void notFound(NotFoundException e){
    log.info("Not found :" + e.getMessage());
    throw e;
  }

}
