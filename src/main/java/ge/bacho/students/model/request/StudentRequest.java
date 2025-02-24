package ge.bacho.students.model.request;

import lombok.*;

@Data
@AllArgsConstructor
public class StudentRequest {
    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private long facultyId;

    private int credits;

    private double gpa;
}
