package ge.bacho.students.service;

import ge.bacho.students.error.NotFoundException;
import ge.bacho.students.model.dto.UniversityDTO;
import ge.bacho.students.model.request.UniversityRequest;
import ge.bacho.students.persistence.entity.University;
import ge.bacho.students.persistence.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;

    public Page<UniversityDTO> getAllUniversities(int page, int pageSize) {
        return universityRepository.findAllUniversities(PageRequest.of(page, pageSize));
    }

    public Page<UniversityDTO> getUniversitiesByLocation(int page, int pageSize, String location) {
        return universityRepository.findUniversitiesByLocation(location, PageRequest.of(page, pageSize));
    }

    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
    }

    public void createUniversity(UniversityRequest universityRequest) {
        University university = new University();
        university.setName(universityRequest.getName());
        university.setLocation(universityRequest.getLocation());

        universityRepository.save(university);
    }

    public UniversityDTO updateUniversity(Long id, UniversityRequest universityRequest) {
        University university = universityRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        university.setName(universityRequest.getName());
        university.setLocation(universityRequest.getLocation());

        universityRepository.save(university);
        return mapUniversity(university);
    }

    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    public UniversityDTO mapUniversity(University university) {
        return new UniversityDTO(university.getId(), university.getName(), university.getLocation());
    }

    private NotFoundException buildNotFoundException(Long id){
        String errorMessage = String.format("University with id '%s' not found", id);
        return new NotFoundException(errorMessage);
    }
}
