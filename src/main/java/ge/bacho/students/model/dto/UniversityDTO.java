package ge.bacho.students.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class UniversityDTO {
    @Setter(AccessLevel.NONE)
    private final Long id;

    private String name;

    private String location;
}
