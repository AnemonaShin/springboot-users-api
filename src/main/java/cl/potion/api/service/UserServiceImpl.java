package cl.potion.api.service;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import cl.potion.api.entity.UserEntity;
import cl.potion.api.exception.ServiceException;
import cl.potion.api.repository.UserRepository;
import cl.potion.api.request.UserRequest;
import cl.potion.api.response.DefaultResponse;
import cl.potion.api.util.PasswordUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Implements the high interface of service for uses on users managements.
 *
 * @author AnemonaShin (Christian Ramirez) - cramireza1997@gmail.com
 * @version 1.0.0
 * @since 10-05-2026
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  // TODO: corregir errores.
  public DefaultResponse registerUser(UserRequest body) throws ServiceException {

    repository.save(UserEntity.builder()
        .username(body.getUsername())
        .password(PasswordUtil.passwordEncrypt(body.getPassword()))
        .email(body.getEmail())
        .createAt(Date.valueOf(LocalDateTime.now().toLocalDate()))
        .updatedAt(Date.valueOf(LocalDateTime.now().toLocalDate()))
        .active(true)
        .build());

    return DefaultResponse.builder().code("00").message("USER REGISTERED").build();
  }

  // TODO: corregir errores.
  public Page<UserEntity> getAllUsers(PageRequest pageRequest) throws ServiceException {
    return repository.findAll(pageRequest);
  }

  // TODO: corregir errores.
  public DefaultResponse searchByUsername(String username) throws ServiceException {

    try {
      UserEntity userSearched;
      try {
        userSearched = repository.searchByUsername(username);
      } catch (JpaObjectRetrievalFailureException jEx) {
        throw new ServiceException("400", "ERROR");
      }
      return DefaultResponse.builder().code("00").message("USER SEARCHED").response(
          userSearched)
          .build();
    } catch (ServiceException ex) {
      log.error("Error inside getUserByUsername, ex: {}", ex);
      throw new ServiceException(ex.getLocalizedMessage(), ex.getMessage());
    }

  }

}
