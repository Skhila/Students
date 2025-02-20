package ge.bacho.students.controller;

import ge.bacho.students.model.dto.StudentDTO;
import ge.bacho.students.model.request.StudentRequest;
import ge.bacho.students.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    Page<StudentDTO> getStudents(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 @RequestParam(required = false) String universityName,
                                 @RequestParam(required = false) String facultyName,
                                 @RequestParam(required = false) String location) {
        if (universityName != null && !universityName.isEmpty()) {
            return studentService.getStudentsByUniversityName(page, pageSize, universityName);
        } else if (facultyName != null && !facultyName.isEmpty()) {
            return studentService.getStudentsByFacultyName(page, pageSize, facultyName);
        } else if (location != null && !location.isEmpty()) {
            return studentService.getStudentsByLocation(page, pageSize, location);
        } else {
            return studentService.getAllStudents(page, pageSize);
        }
    }

    @GetMapping("{id}")
    StudentDTO getStudent(@PathVariable long id) {
        return studentService.mapStudent(studentService.getStudentById(id));
    }

    @PostMapping
    ResponseEntity<Void> createStudent(@RequestBody StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    StudentDTO updateStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
