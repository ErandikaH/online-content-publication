package sl.zerobeta.assessment.backend.model.enums;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public enum ContentStatus {
    CREATED(1),
    UPDATED(2),
    DELETED(3);

    ContentStatus(Integer contentStatus) {
        this.contentStatus = contentStatus;
    }

    private Integer contentStatus;

    public Integer getContentStatus() {
        return contentStatus;
    }
}
