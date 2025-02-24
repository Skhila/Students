package ge.bacho.students.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
public class FacultyRequest {
    @NotBlank
    @Size(min = 1, max = 88)
    private String name;

    @Positive
    private double tuitionFee;

    @Min(120)
    private int creditsRequiredForGraduation;

    @Positive
    private Long universityId;
}
