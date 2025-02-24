package ge.bacho.students.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
public class StudentRequest {
    @NotBlank
    @Size(min = 1, max = 22)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 22)
    private String lastName;

    @NotBlank
    @Size(min = 1, max = 55)
    private String email;

    @Min(16)
    private int age;

    @Positive
    private Long facultyId;

    @Positive
    private int credits;

    @Min(1)
    @Max(4)
    private double gpa;
}
