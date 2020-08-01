package sl.zerobeta.assessment.backend.model;

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
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Integer categoryId;
}
