package ge.bacho.students.persistence.repository;

import ge.bacho.students.model.dto.UniversityDTO;
import ge.bacho.students.persistence.entity.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query("SELECT new ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location)" +
            "FROM University u")
    Page<UniversityDTO> findAllUniversities(Pageable pageable);

    @Query("SELECT new ge.bacho.students.model.dto.UniversityDTO(u.id, u.name, u.location)" +
            "FROM University u WHERE u.location = :location")
    Page<UniversityDTO> findUniversitiesByLocation(String location, Pageable pageable);
}
