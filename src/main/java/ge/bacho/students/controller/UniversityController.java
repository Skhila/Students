package ge.bacho.students.controller;

import ge.bacho.students.model.dto.UniversityDTO;
import ge.bacho.students.model.request.UniversityRequest;
import ge.bacho.students.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universities")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping
    Page<UniversityDTO> getUniversities(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(required = false) String location) {
        if (location == null || location.isEmpty()) {
            return universityService.getAllUniversities(page, pageSize);
        } else {
            return universityService.getUniversitiesByLocation(page, pageSize, location);
        }
    }

    @GetMapping("{id}")
    UniversityDTO getUniversitiesById(@PathVariable int id) {
        return universityService.mapUniversity(universityService.getUniversityById(id));
    }

    @PostMapping
    ResponseEntity<Void> createUniversity(@RequestBody UniversityRequest universityRequest) {
        universityService.createUniversity(universityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    UniversityDTO updateUniversity(@PathVariable int id, @RequestBody UniversityRequest universityRequest) {
        return universityService.updateUniversity(id, universityRequest);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteUniversity(@PathVariable int id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}
