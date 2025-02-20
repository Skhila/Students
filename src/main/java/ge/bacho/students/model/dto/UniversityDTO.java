package ge.bacho.students.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UniversityDTO {
    @Setter(AccessLevel.NONE)
    private final long id;

    private String name;

    private String location;
}
