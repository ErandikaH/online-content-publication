package sl.zerobeta.assessment.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPublicationId(Long publicationId);
}
