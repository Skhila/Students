package ge.bacho.students.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    @Setter(AccessLevel.NONE)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private FacultyDTO faculty;

    private int credits;

    private double gpa;
}
