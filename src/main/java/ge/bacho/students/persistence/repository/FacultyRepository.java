package ge.bacho.students.persistence.repository;

import ge.bacho.students.model.dto.FacultyDTO;
import ge.bacho.students.persistence.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Query("SELECT new ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))" +
            "FROM Faculty f JOIN f.university u")
    Page<FacultyDTO> findAllFaculties(Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))" +
            "FROM Faculty f JOIN f.university u " +
            "WHERE u.name = :universityName")
    Page<FacultyDTO> findFacultiesByUniversityName(String universityName, Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.FacultyDTO(f.id, f.name, f.tuitionFee, f.creditsRequiredForGraduation, " +
            "NEW ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location))" +
            "FROM Faculty f JOIN f.university u " +
            "WHERE f.tuitionFee = :tuitionFee")
    Page<FacultyDTO> findFacultiesByTuitionFee(double tuitionFee, Pageable pageable);
}
