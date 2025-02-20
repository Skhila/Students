package ge.bacho.students.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "university")
@SequenceGenerator( name = "university_seq_gen", sequenceName = "university_seq", allocationSize = 1)
public class University {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "university_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;
}
