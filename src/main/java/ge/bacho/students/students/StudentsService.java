package ge.bacho.students.students;


import ge.bacho.students.students.model.Faculty;
import ge.bacho.students.students.model.Student;
import ge.bacho.students.students.model.University;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void setup() {
        students.add(
                new Student(1, "Bacho", "Skhiladze", "BachoSkhiladze@btu.edu.ge", 21,
                        new Faculty(1, "CS", new University(1, "BTU", "Tbilisi"), 2900, 240),
                        210, 3.8)
        );

        students.add(
                new Student(2, "Nika", "Lomidze", "NikaLomidze@tsu.edu.ge", 20,
                        new Faculty(2, "Engineering", new University(2, "TSU", "Tbilisi"), 2800, 240),
                        230, 3.6)
        );

        students.add(
                new Student(3, "Sopo", "Kakabadze", "SopoKakabadze@iliauni.edu.ge", 22,
                        new Faculty(3, "Medicine", new University(3, "Ilia Uni", "Tbilisi"), 3200, 300),
                        280, 3.9)
        );

        students.add(
                new Student(4, "Elene", "Jorjadze", "EleneJorjadze@btu.edu.ge", 19,
                        new Faculty(4, "Law", new University(4, "BTU", "Tbilisi"), 2500, 210),
                        190, 3.7)
        );

        students.add(
                new Student(5, "Luka", "Tsertsvadze", "LukaTsertsvadze@freeuni.edu.ge", 21,
                        new Faculty(5, "CS", new University(5, "Free Uni", "Tbilisi"), 2700, 240),
                        210, 3.8)
        );

        students.add(
                new Student(6, "Mariam", "Vekua", "MariamVekua@agriuni.edu.ge", 20,
                        new Faculty(6, "Business", new University(6, "Agricultural Uni", "Kutaisi"), 2200, 180),
                        180, 3.5)
        );

        students.add(
                new Student(7, "Mirian", "Kvekveskiri", "MirianKvekveskiri@btu.edu.ge", 20,
                        new Faculty(7, "Business", new University(7, "BTU", "Kutaisi"), 2200, 180),
                        180, 3.5)
        );
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Student> getStudentsWithFilters(String universityName, String location) {
        return students.stream()
                .filter(student -> (universityName == null || student.getFaculty().getUniversity().getName().equalsIgnoreCase(universityName)))
                .filter(student -> (location == null || student.getFaculty().getUniversity().getLocation().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, Student student) {
        students.set(id - 1, student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}
