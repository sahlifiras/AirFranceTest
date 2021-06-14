package com.airfrance.testfirassahli.service.interfaces;

import com.airfrance.testfirassahli.dto.UserDTO;

/**
 * Declaration of method to use in User Service
 *
 * @author firas.sahli
 */
public interface UserService {

    public UserDTO createUser(UserDTO userDTO, Boolean status);

    public UserDTO getUserById(String id);
}
