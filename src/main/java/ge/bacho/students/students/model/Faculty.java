package ge.bacho.students.students.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Faculty {
    private final int id;
    private University university;
    private String name;
    private double tuitionFee;
    private int creditsRequiredForGraduation;

    public Faculty(int id, String name, University university, double tuitionFee, int creditsRequiredForGraduation) {
        this.id = id;
        this.university = university;
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.creditsRequiredForGraduation = creditsRequiredForGraduation;
    }
}
