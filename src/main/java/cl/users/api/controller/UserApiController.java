package cl.users.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.users.api.exception.ServiceException;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;
import cl.users.api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/v1")
public class UserApiController {

  UserService userService;

  public UserApiController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<Object> registerUser(
      @RequestBody UserRequest body)
      throws ServiceException {
    try {
      DefaultResponse response = userService.registerUser(body);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      return ResponseEntity.badRequest().build();
    }
  }

}
