package ee.practice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 6/1/2016.
 */
@Service("userDetailsService")
public class DBUserDetailsService implements UserDetailsService {
  @Autowired UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User u = service.loadByUsername(username)
        .orElseThrow(
            ()->new UsernameNotFoundException("Cant find a user with this username : " + username));


    return new org.springframework.security.core.userdetails.User(
      u.getUsername(),u.getPwd(), true, true, true, true, emptyList());
  }
}
