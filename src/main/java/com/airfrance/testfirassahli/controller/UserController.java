package com.airfrance.testfirassahli.controller;

import com.airfrance.testfirassahli.dto.UserDTO;
import com.airfrance.testfirassahli.exception.UserNotFoundException;
import com.airfrance.testfirassahli.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * This Controller manages all requests on user
 *
 * @author firas.sahli
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This action will Create a new user and check if the input object is valid
     *
     * @param userDto object user
     * @return ResponseEntity
     */
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto, @RequestParam(defaultValue = "false") Boolean status) {
        UserDTO result = userService.createUser(userDto, status);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This action will get the entity with the given ID.
     *
     * @param id  of user.
     * @return UserDTO
     */
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        UserDTO result = userService.getUserById(id);
        /**
         * check if the result is null to return UserNotFoundException
         */
        if (result == null)
            throw  new UserNotFoundException("User with id: " + id + " Not found");
        return result;
    }
}
