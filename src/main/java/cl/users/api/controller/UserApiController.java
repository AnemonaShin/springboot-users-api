package cl.users.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.users.api.exception.ServiceException;
import cl.users.api.model.UserModel;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;
import cl.users.api.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author AnemonaShin (Christian Ramirez) - cramireza1997@gmail.com
 * @version 1.0.0
 * @since 10-05-2026
 */
@RestController
@RequestMapping(path = "/v1")
public class UserApiController {

  UserService userService;

  public UserApiController(UserService userService) {
    this.userService = userService;
  }

  @Tag(name = "register", description = "Endpoint designed to register a new User.")
  @ApiResponse(description = "Respond custom response object.")
  @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

  @GetMapping("/search/{user_name}")
  public String getUserByUserName(
      @PathVariable(name = "user_name", required = true) String userName) {
    return userName;
  }

  @GetMapping("/list_users")
  public Page<UserModel> getAllUsers(
      @RequestParam int page,
      @RequestParam int size) throws ServiceException {
    return userService.getAllUsers(PageRequest.of(page, size));
  }

}
