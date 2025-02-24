package ge.bacho.students.model.request;

import lombok.*;

@Data
@AllArgsConstructor
public class FacultyRequest {
    private String name;

    private double tuitionFee;

    private int creditsRequiredForGraduation;

    private long universityId;
}
