package sl.zerobeta.assessment.backend.model.enums;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public enum NotificationStatus {
    FAILED(0),
    PENDING(1),
    SENT(2);

    NotificationStatus(Integer notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    private Integer notificationStatus;

    public Integer getNotificationStatus() {
        return notificationStatus;
    }
}
