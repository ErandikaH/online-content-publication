package sl.zerobeta.assessment.backend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private String countryOfOrigin;
    private String description;
    private String fireBaseRegistration;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Publication> publicationList;
}
