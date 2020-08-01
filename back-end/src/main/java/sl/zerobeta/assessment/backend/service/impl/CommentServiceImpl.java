package sl.zerobeta.assessment.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.exceptions.PublicationNotFoundException;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.model.User;
import sl.zerobeta.assessment.backend.model.enums.ContentStatus;
import sl.zerobeta.assessment.backend.repository.CommentRepository;
import sl.zerobeta.assessment.backend.repository.PublicationRepository;
import sl.zerobeta.assessment.backend.repository.UserRepository;
import sl.zerobeta.assessment.backend.service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final PublicationRepository publicationRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(PublicationRepository publicationRepository,
                                  CommentRepository commentRepository,
                                  UserRepository userRepository) {
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void addComment(PublicationCommentDTO publicationCommentDTO) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(ContentStatus.CREATED.getContentStatus());
        statusList.add(ContentStatus.UPDATED.getContentStatus());
        Optional<Publication> optionalPublication = this.publicationRepository.findByIdAndStatusIn(publicationCommentDTO.getPublicationId(), statusList);
        if(!optionalPublication.isPresent()){
            throw new PublicationNotFoundException("Not found");
        }
        Optional<User> optionalUser = userRepository.findById(publicationCommentDTO.getUserId());
        User user = optionalUser.get();
        Publication publication = optionalPublication.get();
        Comment comment = new Comment();
        comment.setPublication(publication);
        comment.setUser(user);
        comment.setComments(publicationCommentDTO.getComments());
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long publicationId) {
        List<Comment> commentList = commentRepository.findByPublicationId(publicationId);
        return commentList;
    }
}
