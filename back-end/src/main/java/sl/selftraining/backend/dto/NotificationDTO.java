package sl.selftraining.backend.dto;

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
public class NotificationDTO {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String category;
}
