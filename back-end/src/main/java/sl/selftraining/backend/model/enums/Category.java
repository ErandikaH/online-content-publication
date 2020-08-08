package sl.selftraining.backend.model.enums;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public enum Category {
    ML_AI(1, "ML/AI"),
    BIG_DATA(2, "Big Data"),
    MICROSERVICES(3, "Micro-services");

    private Integer categoryNumber;
    private String categoryDescription;

    Category(Integer categoryNumber, String categoryDescription) {
        this.categoryNumber = categoryNumber;
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
