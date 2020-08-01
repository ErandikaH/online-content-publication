package sl.zerobeta.assessment.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.dto.SubscriptionDTO;
import sl.zerobeta.assessment.backend.model.Subscription;
import sl.zerobeta.assessment.backend.repository.SubscriptionRepository;
import sl.zerobeta.assessment.backend.service.SubscriptionService;

import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
    @Override
    public void addSubscription(SubscriptionDTO subscriptionDTO) {
        Optional<Subscription> optionalSubscription = this.subscriptionRepository.findByUserIdAndCategoryId(subscriptionDTO.getUserId(), subscriptionDTO.getCategoryId());
        if(!optionalSubscription.isPresent()){
            Subscription subscription = new Subscription();
            subscription.setUserId(subscriptionDTO.getUserId());
            subscription.setCategoryId(subscriptionDTO.getCategoryId());
            subscriptionRepository.save(subscription);
        }
    }
}
