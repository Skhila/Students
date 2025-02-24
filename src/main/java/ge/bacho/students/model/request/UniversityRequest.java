package ge.bacho.students.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
public class UniversityRequest {
    @NotBlank
    @Size(min = 1, max = 88)
    private String name;

    @NotBlank
    @Size(min = 1, max = 88)
    private String location;
}
