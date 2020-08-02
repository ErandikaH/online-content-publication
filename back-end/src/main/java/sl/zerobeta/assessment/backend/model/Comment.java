package sl.zerobeta.assessment.backend.model;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comments;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Publication publication;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
