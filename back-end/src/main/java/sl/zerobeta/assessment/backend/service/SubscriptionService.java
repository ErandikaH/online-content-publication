package sl.zerobeta.assessment.backend.service;

import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.dto.SubscriptionDTO;
import sl.zerobeta.assessment.backend.model.Comment;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface SubscriptionService {
    void addSubscription(SubscriptionDTO subscriptionDTO);
}
