package sl.zerobeta.assessment.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.model.NotificationMessage;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.model.enums.ContentStatus;
import sl.zerobeta.assessment.backend.model.enums.NotificationStatus;
import sl.zerobeta.assessment.backend.repository.CommentRepository;
import sl.zerobeta.assessment.backend.repository.NotificationRepository;
import sl.zerobeta.assessment.backend.repository.UserRepository;
import sl.zerobeta.assessment.backend.service.NotificationService;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void addNotificationMessage(Long userId, Publication publication){
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.setUserId(userId);
        notificationMessage.setNotificationStatus(NotificationStatus.PENDING.getNotificationStatus());
        notificationMessage.setPublicationId(publication.getId());
        notificationMessage.setPublicationStatus(publication.getStatus());
        notificationMessage.setTitle(publication.getTitle());
        notificationMessage.setCategoryId(publication.getCategory());

        if(publication.getStatus().equals(ContentStatus.CREATED.getContentStatus())){
            notificationMessage.setMessage("You have a new Article"); //TODO get messages from a general location
        }
        else if(publication.getStatus().equals(ContentStatus.UPDATED.getContentStatus())){
            notificationMessage.setMessage("Article "+publication.getTitle()+" has been updated");
        }
        else if(publication.getStatus().equals(ContentStatus.DELETED.getContentStatus())){
            notificationMessage.setMessage("Article "+publication.getTitle()+" has been deleted");
        }
        this.notificationRepository.save(notificationMessage);
    }

    @Override
    public List<NotificationMessage> getPendingMessages() {
        return this.notificationRepository.findByNotificationStatus(NotificationStatus.PENDING.getNotificationStatus());
    }

    @Override
    public void updateNotificationStatus(List<NotificationMessage> notificationMessageList) {
        this.notificationRepository.saveAll(notificationMessageList);
    }
}
