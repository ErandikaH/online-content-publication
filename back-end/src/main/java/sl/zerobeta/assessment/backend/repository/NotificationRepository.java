package sl.zerobeta.assessment.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.zerobeta.assessment.backend.model.NotificationMessage;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface NotificationRepository extends JpaRepository<NotificationMessage, Long> {
    List<NotificationMessage> findByNotificationStatus(Integer notificationStatus);
}
