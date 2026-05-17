package cl.potion.api.dto;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.potion.api.entity.UserEntity;

@Repository
public interface UserDto extends JpaRepository<UserEntity, BigInteger> {

    UserEntity searchByUsername(String username);

}
