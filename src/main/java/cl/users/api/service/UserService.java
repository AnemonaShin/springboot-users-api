package cl.users.api.service;

import cl.users.api.exception.ServiceException;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;

public interface UserService {

    public DefaultResponse registerUser(UserRequest body) throws ServiceException;

}
