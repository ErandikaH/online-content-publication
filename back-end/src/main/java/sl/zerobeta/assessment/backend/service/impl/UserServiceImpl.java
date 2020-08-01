package sl.zerobeta.assessment.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.dto.UserDTO;
import sl.zerobeta.assessment.backend.dto.UserUpdateDTO;
import sl.zerobeta.assessment.backend.exceptions.UserAlreadyExistException;
import sl.zerobeta.assessment.backend.exceptions.UserNotFoundException;
import sl.zerobeta.assessment.backend.model.Publication;
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
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        Optional<User> optionalUser = this.userRepository.findById(userUpdateDTO.getUserId());
        User user = null;
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User already exist");
        }
        user = optionalUser.get();
        if(null!=userUpdateDTO.getFullName() && !userUpdateDTO.getFullName().isEmpty()){
            user.setFullName(userUpdateDTO.getFullName());
        }
        if(null!=userUpdateDTO.getCountryOfOrigin() && !userUpdateDTO.getCountryOfOrigin().isEmpty()){
            user.setCountryOfOrigin(userUpdateDTO.getCountryOfOrigin());
        }
        if(null!=userUpdateDTO.getDescription() && !userUpdateDTO.getDescription().isEmpty()){
            user.setDescription(userUpdateDTO.getDescription());
        }
        this.userRepository.save(user);
    }

}
