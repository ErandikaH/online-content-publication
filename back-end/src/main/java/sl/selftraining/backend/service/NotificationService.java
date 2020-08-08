package sl.selftraining.backend.service;

import sl.selftraining.backend.model.NotificationMessage;
import sl.selftraining.backend.model.Publication;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface NotificationService {
    void addNotificationMessage(Long userId, Publication publication);
    void updateNotificationStatus(List<NotificationMessage> notificationMessageList);
    List<NotificationMessage> getPendingMessages();
}
