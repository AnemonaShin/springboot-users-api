package cl.users.api.service;

import java.sql.Date;
import java.time.LocalDateTime;

import cl.users.api.exception.ServiceException;
import cl.users.api.model.UserModel;
import cl.users.api.repository.UserRepository;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;

public class UserServiceImpl implements UserService {

  UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

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

}
