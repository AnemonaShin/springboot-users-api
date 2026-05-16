package cl.users.api.service;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.users.api.exception.ServiceException;
import cl.users.api.model.UserModel;
import cl.users.api.repository.UserRepository;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  // TODO: corregir errores.
  public DefaultResponse registerUser(UserRequest body) throws ServiceException {

    repository.save(UserModel.builder()
        .name(body.getName())
        .lastName(body.getLastName())
        .email(body.getEmail())
        .address(body.getAddress())
        .createAt(Date.valueOf(LocalDateTime.now().toLocalDate()))
        .updatedAt(Date.valueOf(LocalDateTime.now().toLocalDate()))
        .active(true)
        .build());

    return DefaultResponse.builder().code("00").message("USER REGISTERED").build();
  }

  // TODO: corregir errores.
  public Page<UserModel> getAllUsers(PageRequest pageRequest) throws ServiceException {
    return repository.findAll(pageRequest);
  }

  // TODO: corregir errores.
  public DefaultResponse getUserByEmail(String email) throws ServiceException {

    try {
      var userSearched = repository.getByEmail(email);

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
