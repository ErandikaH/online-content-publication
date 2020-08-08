package sl.selftraining.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.selftraining.backend.model.Comment;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPublicationId(Long publicationId);
}
