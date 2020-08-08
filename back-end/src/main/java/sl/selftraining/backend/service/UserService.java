package sl.selftraining.backend.service;

import sl.selftraining.backend.dto.UserDTO;
import sl.selftraining.backend.model.User;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface UserService {
    void initializeUser(UserDTO userDTO) ;

    User findUserByEmail(String email);

    void updateUser(UserDTO userDTO, Long userId);

}
