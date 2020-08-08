package sl.selftraining.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Data
public class SubscriptionDTO {
    @NotNull
    @NotEmpty
    private Long userId;
    @NotNull
    @NotEmpty
    private Integer categoryId;
}
