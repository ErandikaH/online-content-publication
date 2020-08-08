package sl.selftraining.backend.service;

import sl.selftraining.backend.dto.PublicationCommentDTO;
import sl.selftraining.backend.model.Comment;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface CommentService {

    void addComment(PublicationCommentDTO publicationCommentDTO);

    List<Comment> getComments(Long publicationId);
}
