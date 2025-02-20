package ge.bacho.students.persistence.repository;

import ge.bacho.students.persistence.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
