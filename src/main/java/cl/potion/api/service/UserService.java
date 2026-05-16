package cl.potion.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.potion.api.exception.ServiceException;
import cl.potion.api.model.UserModel;
import cl.potion.api.request.UserRequest;
import cl.potion.api.response.DefaultResponse;

@Service
public interface UserService {

    public DefaultResponse registerUser(UserRequest body) throws ServiceException;

    public Page<UserModel> getAllUsers(PageRequest pageRequest) throws ServiceException;

    public DefaultResponse getUserByEmail(String email) throws ServiceException;

}
