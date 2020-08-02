package sl.zerobeta.assessment.backend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.service.CommentService;

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

    @ApiOperation(value = "Add Comment",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void addComment(@RequestBody PublicationCommentDTO publicationCommentDTO){
        this.commentService.addComment(publicationCommentDTO);
    }

    @ApiOperation(value = "Get Comments per Publication",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{publicationId}")
    public List<Comment> getComments(@PathVariable("publicationId") Long publicationId){
        return this.commentService.getComments(publicationId);
    }
}
