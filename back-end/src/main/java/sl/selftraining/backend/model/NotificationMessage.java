package sl.selftraining.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class NotificationMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long publicationId;
    private Integer categoryId;
    private String title;
    private String message;
    private Integer publicationStatus;
    private Integer notificationStatus;
}
