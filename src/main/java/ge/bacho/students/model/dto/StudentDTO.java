package ge.bacho.students.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class StudentDTO {
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private FacultyDTO faculty;

    private int credits;

    private double gpa;
}
