package sl.selftraining.backend.scheduler;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import sl.selftraining.backend.model.NotificationMessage;
import sl.selftraining.backend.model.Subscription;
import sl.selftraining.backend.model.User;
import sl.selftraining.backend.model.enums.NotificationStatus;
import sl.selftraining.backend.repository.SubscriptionRepository;
import sl.selftraining.backend.repository.UserRepository;
import sl.selftraining.backend.service.NotificationService;

import java.util.List;
import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
//@Component
public class NotificationScheduler {
    private final NotificationService notificationService;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public NotificationScheduler(NotificationService notificationService,
                                 UserRepository userRepository,
                                 SubscriptionRepository subscriptionRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    //@Scheduled(fixedDelay = 10000)
    public void sendNotificationMessage() throws FirebaseMessagingException {
        List<NotificationMessage> notificationMessageList = this.notificationService.getPendingMessages();
        for(NotificationMessage notificationMessage : notificationMessageList){
            //TODO Refactor
            Optional<User> optionalUser = this.userRepository.findById(notificationMessage.getUserId());
            Optional<Subscription> optionalSubscription = this.subscriptionRepository.findByUserIdAndCategoryId(notificationMessage.getUserId(), notificationMessage.getCategoryId());
            if(optionalUser.isPresent() && optionalSubscription.isPresent()) {
                Notification notification = Notification.builder()
                        .setTitle("Notification Alert")
                        .setBody(notificationMessage.getMessage())
                        .build();
                Message message = Message.builder()
                        .setNotification(notification)
                        .putData("click_action", "WEB_NOTIFICATION_CLICK")
                        .putData("publication_id", notificationMessage.getPublicationId().toString())
                        .putData("publication_title", notificationMessage.getTitle())
                        .putData("publication_status", notificationMessage.getPublicationStatus().toString())
                        .setToken(optionalUser.get().getFireBaseRegistration())
                        .build();
                FirebaseMessaging.getInstance().send(message);
                notificationMessage.setNotificationStatus(NotificationStatus.SENT.getNotificationStatus());
            }
            else{
                notificationMessage.setNotificationStatus(NotificationStatus.FAILED.getNotificationStatus());
            }
        }
        this.notificationService.updateNotificationStatus(notificationMessageList);
    }
}
