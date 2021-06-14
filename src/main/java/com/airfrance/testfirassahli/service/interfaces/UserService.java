package com.airfrance.testfirassahli.service.interfaces;

import com.airfrance.testfirassahli.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO, Boolean status);
}
