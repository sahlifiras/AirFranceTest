package com.airfrance.testfirassahli;

import com.airfrance.testfirassahli.dto.UserDTO;
import com.airfrance.testfirassahli.entity.User;
import com.airfrance.testfirassahli.repository.UserRepository;
import com.airfrance.testfirassahli.service.implementations.UserServiceImpl;
import com.airfrance.testfirassahli.service.interfaces.UserService;
import com.airfrance.testfirassahli.util.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
@SpringBootTest
class TestfirassahliApplicationTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl(userRepository);

    User user = new User();
    UserDTO userDTO = new UserDTO();

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        user.setId("60c74e32a938a71945c7e092");
        user.setFirstName("firas");
        user.setLastName("sahli");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthDate(format.parse("1995-06-17"));
        user.setAddress("courbevoie, paris France");
        user.setActiveUser(false);

        userDTO.setId("60c74e32a938a71945c7e092");
        userDTO.setFirstName("firas");
        userDTO.setLastName("sahli");
        userDTO.setBirthDate(format.parse("1995-06-17"));
        userDTO.setAddress("courbevoie, paris France");
        userDTO.setActiveUser(false);
    }

    @Test
    public void getUserById() throws ParseException {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Assert.assertEquals(userService.getUserById(user.getId()).getId(), user.getId());
    }
    @Test
    public void createUser() throws ParseException {

        when(userRepository.save(any())).thenReturn(ObjectMapper.map(userDTO, User.class));
        Assert.assertNotNull(userService.createUser(userDTO, false));
    }

}
