package ge.bacho.students.persistence.repository;

import ge.bacho.students.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
