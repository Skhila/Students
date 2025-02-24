package ge.bacho.students.service;

import ge.bacho.students.model.dto.FacultyDTO;
import ge.bacho.students.model.dto.UniversityDTO;
import ge.bacho.students.model.request.FacultyRequest;
import ge.bacho.students.persistence.entity.Faculty;
import ge.bacho.students.persistence.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final UniversityService universityService;
    private final FacultyRepository facultyRepository;

    public Page<FacultyDTO> getAllFaculties(int page, int pageSize) {
        return facultyRepository.findAllFaculties(PageRequest.of(page, pageSize));
    }

    public Faculty getFacultyById(long id) {
        return facultyRepository.findById(id).get();
    }

    public Page<FacultyDTO> getFacultiesByUniversityName(int page, int pageSize, String universityName) {
        return facultyRepository.findFacultiesByUniversityName(universityName, PageRequest.of(page, pageSize));
    }

    public Page<FacultyDTO> getFacultiesByTuitionFee(int page, int pageSize, double tuitionFee) {
        return facultyRepository.findFacultiesByTuitionFee(tuitionFee, PageRequest.of(page, pageSize));
    }

    public void createFaculty(FacultyRequest facultyRequest) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyRequest.getName());
        faculty.setTuitionFee(facultyRequest.getTuitionFee());
        faculty.setCreditsRequiredForGraduation(facultyRequest.getCreditsRequiredForGraduation());
        faculty.setUniversity(universityService.getUniversityById(facultyRequest.getUniversityId()));

        facultyRepository.save(faculty);
    }

    public FacultyDTO updateFaculty(long id, FacultyRequest facultyRequest) {
        Faculty faculty = facultyRepository.findById(id).get();
        faculty.setName(facultyRequest.getName());
        faculty.setTuitionFee(facultyRequest.getTuitionFee());
        faculty.setCreditsRequiredForGraduation(facultyRequest.getCreditsRequiredForGraduation());

        if (facultyRequest.getUniversityId() != faculty.getUniversity().getId()) {
            faculty.setUniversity(universityService.getUniversityById(facultyRequest.getUniversityId()));
        }

        facultyRepository.save(faculty);
        return mapFaculty(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public FacultyDTO mapFaculty(Faculty faculty) {
        return new FacultyDTO(faculty.getId(), faculty.getName(), faculty.getTuitionFee(), faculty.getCreditsRequiredForGraduation(),
                new UniversityDTO(faculty.getUniversity().getId(), faculty.getUniversity().getName(), faculty.getUniversity().getLocation())
        );
    }

}

