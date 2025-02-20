package ge.bacho.students.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FacultyDTO {
    @Setter(AccessLevel.NONE)
    private long id;

    private String name;

    private double tuitionFee;

    private int creditsRequiredForGraduation;

    private UniversityDTO university;
}
