package com.airfrance.testfirassahli.controller;

import com.airfrance.testfirassahli.dto.UserDTO;
import com.airfrance.testfirassahli.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto, @RequestParam(defaultValue = "false") Boolean status) {
        UserDTO result = userService.createUser(userDto, status);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
