package sl.zerobeta.assessment.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.dto.UserDTO;
import sl.zerobeta.assessment.backend.exceptions.UserAlreadyExistException;
import sl.zerobeta.assessment.backend.exceptions.UserNotFoundException;
import sl.zerobeta.assessment.backend.model.User;
import sl.zerobeta.assessment.backend.repository.UserRepository;
import sl.zerobeta.assessment.backend.service.UserService;

import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(!optionalUser.isPresent()){
            userRepository.save(user);
        }else{
            throw new UserAlreadyExistException("User already exist");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User already exist");
        }
        return optionalUser.get();
    }

    @Override
    public void updateUser(UserDTO userDTO, Long userId) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        User user = null;
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User already exist");
        }
        user = optionalUser.get();
        if(null!=userDTO.getEmail() && !userDTO.getEmail().isEmpty()){
            user.setEmail(userDTO.getEmail());
        }
        if(null!=userDTO.getFullName() && !userDTO.getFullName().isEmpty()){
            user.setFullName(userDTO.getFullName());
        }
        if(null!=userDTO.getCountryOfOrigin() && !userDTO.getCountryOfOrigin().isEmpty()){
            user.setCountryOfOrigin(userDTO.getCountryOfOrigin());
        }
        if(null!=userDTO.getDescription() && !userDTO.getDescription().isEmpty()){
            user.setDescription(userDTO.getDescription());
        }
        if(null!=userDTO.getPassword() && !userDTO.getPassword().isEmpty()){
            user.setPassword(userDTO.getPassword());
        }
        this.userRepository.save(user);
    }

}
