package sl.zerobeta.assessment.backend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.UserDTO;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.service.UserService;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Add User",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        this.userService.initializeUser(userDTO);
    }

    @ApiOperation(value = "Update User Details",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO){
        this.userService.updateUser(userDTO, userId);
    }
}
