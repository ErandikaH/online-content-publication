package sl.zerobeta.assessment.backend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.SubscriptionDTO;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.service.SubscriptionService;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("subscription")
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @ApiOperation(value = "Add Subscriptions",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void addSubscription(@RequestBody SubscriptionDTO subscriptionDTO){
        this.subscriptionService.addSubscription(subscriptionDTO);
    }
}
