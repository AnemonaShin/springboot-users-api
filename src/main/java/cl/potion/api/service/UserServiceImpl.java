package cl.potion.api.service;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.potion.api.dto.UserDto;
import cl.potion.api.entity.UserEntity;
import cl.potion.api.exception.ServiceException;
import cl.potion.api.request.UserRequest;
import cl.potion.api.response.DefaultResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  UserDto repository;

  public UserServiceImpl(UserDto repository) {
    this.repository = repository;
  }

  // TODO: corregir errores.
  public DefaultResponse registerUser(UserRequest body) throws ServiceException {

    repository.save(UserEntity.builder()
        .username(body.getName())
        .password(body.getLastName())
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
      var userSearched = repository.searchByUsername(username);

      if (userSearched == null) {
        throw new ServiceException("400", "ERROR");
      }

      return DefaultResponse.builder().code("00").message("USER SEARCHED").response(
          userSearched)
          .build();
    } catch (ServiceException ex) {
      log.error("Error inside getUserByEmail, ex: {}", ex);
      throw new ServiceException(ex.getLocalizedMessage(), ex.getMessage());
    }

  }

}
