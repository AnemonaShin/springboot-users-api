package cl.potion.api.repository;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.potion.api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

  UserEntity searchByUsername(String username);

  UserEntity searchById(BigInteger userId);

  Page<UserEntity> searchAllByActiveTrue(Pageable pageable);
}
