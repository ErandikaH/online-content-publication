package sl.selftraining.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.selftraining.backend.model.NotificationMessage;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface NotificationRepository extends JpaRepository<NotificationMessage, Long> {
    List<NotificationMessage> findByNotificationStatus(Integer notificationStatus);
}
