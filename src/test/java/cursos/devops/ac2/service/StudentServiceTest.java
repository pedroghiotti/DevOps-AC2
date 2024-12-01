package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.entity.Course;
import cursos.devops.ac2.entity.Student;
import cursos.devops.ac2.enums.AccountType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired StudentService studentService;
    @Autowired CourseService courseService;

    @Test
    public void shouldRewardStudentWith3CoinsOnConcludingCourseWithGradeGte7() {
        // Arrange
        Student student = studentService.createStudent(
            new StudentDTO(
                "Student",
                0,
                "student@institution.com",
                "passw0rd123",
                AccountType.STANDARD
            )
        );

        Course course_a = courseService.createCourse(new CourseDTO("0000", "Curso de Tecnologia 1", "Curso de tecnologia... autoexplicativo.", 100d));
        Course course_b = courseService.createCourse(new CourseDTO("0001", "Curso de Tecnologia 2", "Curso de tecnologia... autoexplicativo.", 100d));
        Course course_c = courseService.createCourse(new CourseDTO("0002", "Curso de Tecnologia 3", "Curso de tecnologia... autoexplicativo.", 100d));

        studentService.acquireCourse(student.getId(), course_a.getId());
        studentService.acquireCourse(student.getId(), course_b.getId());
        studentService.acquireCourse(student.getId(), course_c.getId());

        studentService.concludeCourse(student.getId(), course_a.getId(), 6.99); // Action
        assertEquals(0, studentService.getStudentById(student.getId()).getCoins(),
                "Não deve recompensar nota menor que 7, mesmo que aproximada."); // Assertion

        studentService.concludeCourse(student.getId(), course_b.getId(), 7d); // Action
        assertEquals(3, studentService.getStudentById(student.getId()).getCoins(),
                "Deve recompensar nota == 7."); // Assertion

        studentService.concludeCourse(student.getId(), course_c.getId(), 10d); // Action
        assertEquals(6, studentService.getStudentById(student.getId()).getCoins(),
                "Deve recompensar nota > 7."); // Assertion
    }

    @Test
    public void shouldRewardStudentWithPremiumOnConcluding12thCourse() {
        // Arrange
        Student student = studentService.createStudent(
                new StudentDTO(
                        "Student",
                        0,
                        "student@institution.com",
                        "passw0rd123",
                        AccountType.STANDARD
                )
        );

        List<Course> courses = List.of(
                courseService.createCourse(new CourseDTO("0000", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0001", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0002", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0003", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0004", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0005", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0006", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0007", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0008", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0009", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0010", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d)),
                courseService.createCourse(new CourseDTO("0011", "Curso de Tecnologia", "Curso de tecnologia... autoexplicativo.", 100d))
        );

        courses.forEach(course -> {
            studentService.acquireCourse(student.getId(), course.getId());
        });

        // Action
        for(int i = 0; i < (courses.size() - 1); i++) {
            studentService.concludeCourse(student.getId(), courses.get(i).getId(), 7d);
        }

        assertEquals(AccountType.PREMIUM, studentService.getStudentById(student.getId()).getAccountType(),
                "Com 11 cursos completos, conta não deve ter sido recompensada aprimorada para premium."); // Assertion

        studentService.concludeCourse(student.getId(), courses.getLast().getId(), 7d); // Action

        assertEquals(AccountType.PREMIUM, studentService.getStudentById(student.getId()).getAccountType(),
                "Ao completar 12 curso, conta deve ser aprimorada para premium."); // Assertion
    }

    @Test
    public void shouldRewardPremiumStudentWith3CoinsOnConcludingCourse() {
        // Arrange
        Student student = studentService.createStudent(
                new StudentDTO(
                        "Student",
                        0,
                        "student@institution.com",
                        "passw0rd123",
                        AccountType.PREMIUM
                )
        );

        Course course = courseService.createCourse(
                new CourseDTO(
                        "0000",
                        "Curso de Tecnologia",
                        "Curso de tecnologia... autoexplicativo.",
                        100d
                )
        );

        studentService.acquireCourse(student.getId(), course.getId());

        // Action
        studentService.concludeCourse(student.getId(), course.getId(), 7d);

        // Assertion
        assertEquals(6, studentService.getStudentById(student.getId()).getCoins());
    }
}
