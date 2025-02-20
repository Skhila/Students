package ge.bacho.students.persistence.repository;

import ge.bacho.students.model.dto.StudentDTO;
import ge.bacho.students.persistence.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new ge.bacho.students.model.dto.StudentDTO(" +
            "    s.id, s.firstName, s.lastName, s.email, s.age," +
            "    NEW ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "        NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))," +
            "    s.credits, s.gpa)" +
            "FROM Student s " +
            "JOIN s.faculty f " +
            "JOIN f.university u")
    Page<StudentDTO> findAllStudents(Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.StudentDTO(" +
            "    s.id, s.firstName, s.lastName, s.email, s.age," +
            "    NEW ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "        NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))," +
            "    s.credits, s.gpa)" +
            "FROM Student s " +
            "JOIN s.faculty f " +
            "JOIN f.university u " +
            "WHERE u.name = :universityName")
    Page<StudentDTO> findStudentsByUniversityName(String universityName, Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.StudentDTO(" +
            "    s.id, s.firstName, s.lastName, s.email, s.age," +
            "    NEW ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "        NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))," +
            "    s.credits, s.gpa)" +
            "FROM Student s " +
            "JOIN s.faculty f " +
            "JOIN f.university u " +
            "WHERE f.name = :facultyName")
    Page<StudentDTO> findStudentsByFacultyName(String facultyName, Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.StudentDTO(" +
            "    s.id, s.firstName, s.lastName, s.email, s.age," +
            "    NEW ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "        NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))," +
            "    s.credits, s.gpa)" +
            "FROM Student s " +
            "JOIN s.faculty f " +
            "JOIN f.university u " +
            "WHERE u.location = :location")
    Page<StudentDTO> findStudentsByLocation(String location, Pageable pageable);
}
