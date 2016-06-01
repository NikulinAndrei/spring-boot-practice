package ee.practice.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrei Nikulin (KEMIT)
 * on 6/1/2016.
 */
interface UserRepository extends JpaRepository<User, Integer>{
  User findOneByUsername( String username );
}
