package cl.users.api.repository;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.users.api.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, BigInteger> {

    UserModel getByEmail(String email);

}
