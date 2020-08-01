package sl.zerobeta.assessment.backend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Data
public class UserDTO {
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String fireBaseRegistration;
}
