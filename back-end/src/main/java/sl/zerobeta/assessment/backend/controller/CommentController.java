package sl.zerobeta.assessment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDeleteDTO;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.service.CommentService;
import sl.zerobeta.assessment.backend.service.PublicationService;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("comment")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void addComment(@RequestBody PublicationCommentDTO publicationCommentDTO){
        this.commentService.addComment(publicationCommentDTO);
    }

    @GetMapping("{publicationId}")
    public List<Comment> getComments(@PathVariable("publicationId") Long publicationId){
        return this.commentService.getComments(publicationId);
    }
}
