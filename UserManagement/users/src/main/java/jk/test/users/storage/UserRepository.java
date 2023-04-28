package jk.test.users.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import jk.test.users.dao.*;

public interface UserRepository extends JpaRepository<User, Integer> {

}
