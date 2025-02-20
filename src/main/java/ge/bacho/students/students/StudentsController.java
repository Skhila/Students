package ge.bacho.students.students;

import ge.bacho.students.students.model.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Profile("local")
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    List<Student> getStudents(@RequestParam(required = false) String uni,
                              @RequestParam(required = false) String location) {

        if (uni != null || location != null) {
            return studentsService.getStudentsWithFilters(uni, location);
        }

        // Default to getting all students if no query parameter is provided
        return studentsService.getStudents();
    }


    @GetMapping("/{id}")
    ResponseEntity<Object> getStudentById(@PathVariable int id) {
        Student student = studentsService.findStudent(id);
        if (student != null){
            return ResponseEntity.ok(student);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id "+ id + " not found.");
    }

    @PostMapping
    void addStudent(@RequestBody Student student){
        studentsService.addStudent(student);
    }

    @PutMapping("{id}")
    ResponseEntity<Object> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student studentToUpdate = studentsService.findStudent(id);
        if (studentToUpdate != null){
            studentsService.updateStudent(id, student);
            return ResponseEntity.ok("Student with id " + id + " updated successfully.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id "+ id + " not found.");
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteStudent(@PathVariable int id){
        Student studentToDelete = studentsService.findStudent(id);
        if (studentToDelete != null){
            studentsService.deleteStudent(studentToDelete);
            return ResponseEntity.ok("Student with id " + id + " deleted successfully.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id "+ id + " not found.");
    }
}
