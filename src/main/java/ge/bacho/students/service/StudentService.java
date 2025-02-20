package ge.bacho.students.service;

import ge.bacho.students.model.dto.FacultyDTO;
import ge.bacho.students.model.dto.StudentDTO;
import ge.bacho.students.model.dto.UniversityDTO;
import ge.bacho.students.model.request.StudentRequest;
import ge.bacho.students.persistence.entity.Student;
import ge.bacho.students.persistence.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyService facultyService;

    public StudentService(StudentRepository studentRepository, FacultyService facultyService) {
        this.studentRepository = studentRepository;
        this.facultyService = facultyService;
    }

    public Page<StudentDTO> getAllStudents(int page, int pageSize) {
        return studentRepository.findAllStudents(PageRequest.of(page, pageSize));
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with ID " + id + " not found"));
    }

    public Page<StudentDTO> getStudentsByUniversityName(int page, int pageSize, String universityName) {
        return studentRepository.findStudentsByUniversityName(universityName, PageRequest.of(page, pageSize));
    }

    public Page<StudentDTO> getStudentsByFacultyName(int page, int pageSize, String facultyName) {
        return studentRepository.findStudentsByFacultyName(facultyName, PageRequest.of(page, pageSize));
    }

    public Page<StudentDTO> getStudentsByLocation(int page, int pageSize, String location) {
        return studentRepository.findStudentsByLocation(location, PageRequest.of(page, pageSize));
    }

    public void createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        student.setGpa(studentRequest.getGpa());
        student.setCredits(studentRequest.getCredits());
        student.setFaculty(facultyService.getFacultyById(studentRequest.getFacultyId()));

        studentRepository.save(student);
    }

    public StudentDTO updateStudent(long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with ID " + id + " not found"));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        student.setGpa(studentRequest.getGpa());
        student.setCredits(studentRequest.getCredits());

        if (studentRequest.getFacultyId() != student.getFaculty().getId()) {
            student.setFaculty(facultyService.getFacultyById(studentRequest.getFacultyId()));
        }
        studentRepository.save(student);
        return mapStudent(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public StudentDTO mapStudent(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                new FacultyDTO(
                        student.getFaculty().getId(),
                        student.getFaculty().getName(),
                        student.getFaculty().getTuitionFee(),
                        student.getFaculty().getCreditsRequiredForGraduation(),
                        new UniversityDTO(
                                student.getFaculty().getUniversity().getId(),
                                student.getFaculty().getUniversity().getName(),
                                student.getFaculty().getUniversity().getLocation()
                        )
                ),
                student.getCredits(),
                student.getGpa()
        );
    }
}
