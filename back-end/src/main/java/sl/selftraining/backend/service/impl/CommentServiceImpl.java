package sl.selftraining.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.selftraining.backend.dto.PublicationCommentDTO;
import sl.selftraining.backend.model.Publication;
import sl.selftraining.backend.model.User;
import sl.selftraining.backend.service.CommentService;
import sl.selftraining.backend.exceptions.PublicationNotFoundException;
import sl.selftraining.backend.model.Comment;
import sl.selftraining.backend.model.enums.ContentStatus;
import sl.selftraining.backend.repository.CommentRepository;
import sl.selftraining.backend.repository.PublicationRepository;
import sl.selftraining.backend.repository.UserRepository;

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
