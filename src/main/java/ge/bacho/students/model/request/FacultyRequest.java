package ge.bacho.students.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacultyRequest {
    private String name;

    private double tuitionFee;

    private int creditsRequiredForGraduation;

    private long universityId;
}
