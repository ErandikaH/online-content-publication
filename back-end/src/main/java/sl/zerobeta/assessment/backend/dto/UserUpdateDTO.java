package sl.zerobeta.assessment.backend.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Getter
@Setter
@EqualsAndHashCode
public class UserUpdateDTO {
    @NotNull
    @NotEmpty
    private Long userId;
    @NotNull
    @NotEmpty
    private String fullName;
    @NotNull
    @NotEmpty
    private String countryOfOrigin;
    @NotNull
    @NotEmpty
    private String description;
}
