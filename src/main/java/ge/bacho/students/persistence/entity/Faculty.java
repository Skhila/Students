package ge.bacho.students.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faculty")
@SequenceGenerator( name = "faculty_seq_gen", sequenceName = "faculty_seq", allocationSize = 1)
public class Faculty {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "faculty_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "tuition_fee", nullable = false)
    private double tuitionFee;

    @Column(name = "credits_required_for_graduation", nullable = false)
    private int creditsRequiredForGraduation;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
}
