package sl.zerobeta.assessment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.UserDTO;
import sl.zerobeta.assessment.backend.service.UserService;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        this.userService.initializeUser(userDTO);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO){
        this.userService.updateUser(userDTO, userId);
    }


}
