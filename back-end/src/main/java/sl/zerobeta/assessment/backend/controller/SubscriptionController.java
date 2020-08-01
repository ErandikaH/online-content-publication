package sl.zerobeta.assessment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.dto.SubscriptionDTO;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.service.CommentService;
import sl.zerobeta.assessment.backend.service.SubscriptionService;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public void addSubscription(@RequestBody SubscriptionDTO subscriptionDTO){
        this.subscriptionService.addSubscription(subscriptionDTO);
    }
}
