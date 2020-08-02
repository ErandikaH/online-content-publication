package sl.zerobeta.assessment.backend.service;

import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDeleteDTO;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.model.Publication;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface CommentService {

    void addComment(PublicationCommentDTO publicationCommentDTO);

    List<Comment> getComments(Long publicationId);
}
