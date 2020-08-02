package sl.zerobeta.assessment.backend.service;

import sl.zerobeta.assessment.backend.dto.UserDTO;
import sl.zerobeta.assessment.backend.model.User;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface UserService {
    void initializeUser(UserDTO userDTO) ;

    User findUserByEmail(String email);

    void updateUser(UserDTO userDTO, Long userId);

}
