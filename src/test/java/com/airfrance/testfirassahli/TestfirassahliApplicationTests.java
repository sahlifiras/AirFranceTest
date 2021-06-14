package com.airfrance.testfirassahli;

import com.airfrance.testfirassahli.controller.UserController;
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
import java.util.Optional;

import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
/**
 * Unit test of our application using Mocks
 *
 * @author firas.sahli
 */
@SpringBootTest
class TestfirassahliApplicationTests {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userServiceInterface;

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl(userRepository);
    @InjectMocks
    private UserController userController = new UserController();

    User user = new User();
    UserDTO userDTO = new UserDTO();

    @Before
    public void setUp() throws ParseException {
        /**
         * Initialize Objects
         */
        MockitoAnnotations.initMocks(this);
        user.setId("60c74e32a938a71945c7e092");
        user.setFirstName("firas");
        user.setLastName("sahli");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthDate(format.parse("1995-06-17"));
        user.setAddress("courbevoie, paris France");
        user.setActiveUser(false);

        userDTO.setId("60c74e32a938a71945c");
        userDTO.setFirstName("firas");
        userDTO.setLastName("sahli");
        userDTO.setBirthDate(format.parse("1995-06-17"));
        userDTO.setAddress("courbevoie, paris France");
        userDTO.setActiveUser(false);
    }

    /**
     * Retreive User by its id.
     * <p>
     * Check that user exists
     * </p>
     */
    @Test
    public void getUserById() throws ParseException {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Assert.assertEquals(userService.getUserById(user.getId()).getId(), user.getId());
    }

    /**
     * Create a user.
     * <p>
     * Check that user is created
     * </p>
     */
    @Test
    public void createUser() throws ParseException {
        when(userRepository.save(any())).thenReturn(ObjectMapper.map(userDTO, User.class));
        Assert.assertNotNull(userService.createUser(userDTO, false));
    }

    /**
     * Create a user inside controller.
     * <p>
     * Check that status code of executed method
     * </p>
     */
    @Test
    public void createUserController() throws Exception {
        when(userServiceInterface.createUser(any(), any())).thenReturn(userDTO);
        ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO, true);
        Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
