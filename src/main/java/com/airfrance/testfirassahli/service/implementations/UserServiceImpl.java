package com.airfrance.testfirassahli.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.airfrance.testfirassahli.dto.UserDTO;
import com.airfrance.testfirassahli.entity.User;
import com.airfrance.testfirassahli.repository.UserRepository;
import com.airfrance.testfirassahli.service.interfaces.UserService;
import com.airfrance.testfirassahli.util.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * Implementation of UserService methods
 *
 * @author firas.sahli
 */
@Service
public class UserServiceImpl  implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * create a new user.
     *
     * @param userDTO
     * @param status
     * @return UserDTO
     */
    @Override
    public UserDTO createUser(UserDTO userDTO, Boolean status) {
        long start = System.currentTimeMillis();
        /**
         * update userDto status
         */
        userDTO.setActiveUser(status);
        User user = ObjectMapper.map(userDTO, User.class);
        UserDTO result = ObjectMapper.map(userRepository.save(user), UserDTO.class);
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("input : " + userDTO);
        log.info("output : " + result);
        log.info("Method createUser execution lasted:" + time + " ms");
        log.info("Method createUser execution ended at:" + new Date());
        return result;
    }

    /**
     * get user details by id
     *
     * @param id
     * @return UserDTO
     */
    @Override
    public UserDTO getUserById(String id) {
        long start = System.currentTimeMillis();
        User user = userRepository.findById(id).orElse(null);
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("input : " + id);
        log.info("output : " + user);
        log.info("Method getUserById execution lasted:" + time + " ms");
        log.info("Method getUserById execution ended at:" + new Date());
        return ObjectMapper.map(user, UserDTO.class);
    }
}
