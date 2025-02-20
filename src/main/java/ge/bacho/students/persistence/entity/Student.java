package ge.bacho.students.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
@SequenceGenerator( name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
public class Student {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "student_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false)
    private double gpa;
}
