package sl.zerobeta.assessment.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
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
@EntityListeners(AuditingEntityListener.class)
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;
    private String details;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDate publishedDate;
    private Integer category;
    private Integer status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    List<Comment> commentList;

}
