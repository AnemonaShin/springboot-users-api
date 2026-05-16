package cl.users.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.users.api.exception.ServiceException;
import cl.users.api.model.UserModel;
import cl.users.api.request.UserRequest;
import cl.users.api.response.DefaultResponse;

@Service
public interface UserService {

    public DefaultResponse registerUser(UserRequest body) throws ServiceException;

    public Page<UserModel> getAllUsers(PageRequest pageRequest) throws ServiceException;

    public DefaultResponse getUserByEmail(String email) throws ServiceException;

}
