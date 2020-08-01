package sl.zerobeta.assessment.backend.service;

import sl.zerobeta.assessment.backend.model.NotificationMessage;
import sl.zerobeta.assessment.backend.model.Publication;

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
