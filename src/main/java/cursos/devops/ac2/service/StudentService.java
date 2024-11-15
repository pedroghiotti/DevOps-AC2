package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.entity.Coupon;
import cursos.devops.ac2.entity.Course;
import cursos.devops.ac2.entity.Student;
import cursos.devops.ac2.entity.Student_Course;
import cursos.devops.ac2.enums.AccountType;
import cursos.devops.ac2.enums.CourseStatus;
import cursos.devops.ac2.repository.CourseRepository;
import cursos.devops.ac2.repository.StudentRepository;
import cursos.devops.ac2.repository.Student_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;
    @Autowired private Student_CourseRepository student_courseRepository;

    @Autowired private CourseRepository courseRepository;

    public Student createStudent(StudentDTO studentDTO) {
        Student newStudent = Student.fromDTO(studentDTO);
        studentRepository.save(newStudent);
        return newStudent;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentDTO::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    public StudentDTO getStudentById(Long id) {
        return StudentDTO.fromEntity(studentRepository.getById(id));
    }

    public void acquireCourse(Long studentId, Long courseId) {
        Student student = studentRepository.getReferenceById(studentId);
        Course course = courseRepository.getReferenceById(courseId);

        Student_Course student_course = new Student_Course(
            student,
            course
        );

        student_courseRepository.save(student_course);
    }

    @Transactional
    public void concludeCourse(Long studentId, Long courseId, Double grade) {
        Student student = studentRepository.getReferenceById(studentId);

        Student_Course student_course = student.getOwnedCourses()
                .stream()
                .filter((Student_Course _student_course) -> !_student_course.getStatus().equals(CourseStatus.CONCLUDED))
                .filter((Student_Course _student_course) -> _student_course.getCourse().getId().equals(courseId))
                .findFirst()
                .orElseThrow();

        student_course.setGrade(grade);
        student_course.setStatus(CourseStatus.CONCLUDED);
        student_courseRepository.save(student_course);

        if(grade >= 7) {
            student.setCoins(student.getCoins() + 3);
        }

        if(student.getAccountType().equals(AccountType.PREMIUM)) {
            student.setCoins(student.getCoins() + 3);

            Coupon coupon = new Coupon();
            coupon.setDiscount(50d);

            student.getOwnedCoupons().add(coupon);
        }
        else if(student.getOwnedCourses()
                .stream()
                .filter(_student_course -> _student_course.getStatus() == CourseStatus.CONCLUDED)
                .count() >= 12) {
            student.setAccountType(AccountType.PREMIUM);
        }

        studentRepository.save(student);
    }
}
