package ge.bacho.students.students.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private final int id;
    private String firstName, lastName, email;
    private int age;
    private Faculty faculty;
    private int creditsEarned;
    private double gpa;

    public Student(int id, String firstName, String lastName, String email, int age, Faculty faculty, int creditsEarned, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.faculty = faculty;
        this.creditsEarned = creditsEarned;
        this.gpa = gpa;
    }
}
