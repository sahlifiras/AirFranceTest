package com.airfrance.testfirassahli.service.implementations;

import com.airfrance.testfirassahli.dto.UserDTO;
import com.airfrance.testfirassahli.entity.User;
import com.airfrance.testfirassahli.repository.UserRepository;
import com.airfrance.testfirassahli.service.interfaces.UserService;
import com.airfrance.testfirassahli.util.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO, Boolean status) {
        userDTO.setActiveUser(status);
        User user = ObjectMapper.map(userDTO, User.class);
        return ObjectMapper.map(userRepository.save(user), UserDTO.class);
    }
}
