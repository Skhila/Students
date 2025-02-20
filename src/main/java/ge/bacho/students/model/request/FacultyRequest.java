package ge.bacho.students.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacultyRequest {
    private String name;

    private double tuitionFee;

    private int creditsRequiredForGraduation;

    private long universityId;
}
