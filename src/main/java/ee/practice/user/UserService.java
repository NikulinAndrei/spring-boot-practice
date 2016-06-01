package ee.practice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 6/1/2016.
 */
@Service
@Transactional
public class UserService {
  @Autowired UserRepository userRepository;

  public Optional<User> loadByUsername(String username){
    return Optional.ofNullable(
        userRepository.findOneByUsername( username )
    );
  }

  public Optional<User> loadById(int id){
    return Optional.ofNullable(
        userRepository.findOne( id )
    );
  }

}
