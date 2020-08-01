package sl.zerobeta.assessment.backend.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Getter
@Setter
@EqualsAndHashCode
public class PublicationDTO {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String summary;
    @NotNull
    @NotEmpty
    private String details;
    @NotNull
    @NotEmpty
    private Integer category;
}
