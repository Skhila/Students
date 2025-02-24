package ge.bacho.students.controller;

import ge.bacho.students.model.dto.FacultyDTO;
import ge.bacho.students.model.request.FacultyRequest;
import ge.bacho.students.service.FacultyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping
    Page<FacultyDTO> getFaculties(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(required = false) String universityName,
                                  @RequestParam(required = false) Double tuitionFee) {
        if (universityName != null && !universityName.isEmpty()) {
            return facultyService.getFacultiesByUniversityName(page, pageSize, universityName);
        } else if (tuitionFee != null) {
            return facultyService.getFacultiesByTuitionFee(page, pageSize, tuitionFee);
        } else {
            return facultyService.getAllFaculties(page, pageSize);
        }
    }

    @GetMapping("{id}")
    FacultyDTO getFaculty(@PathVariable int id) {
        return facultyService.mapFaculty(facultyService.getFacultyById(id));
    }

    @PostMapping
    ResponseEntity<Void> createFaculty(@RequestBody @Valid FacultyRequest facultyRequest) {
        facultyService.createFaculty(facultyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    FacultyDTO updateFaculty(@PathVariable int id, @RequestBody @Valid FacultyRequest facultyRequest) {
        return facultyService.updateFaculty(id, facultyRequest);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteFaculty(@PathVariable int id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
