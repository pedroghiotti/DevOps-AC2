package cursos.devops.ac2.repository;

import cursos.devops.ac2.entity.Coupon;
import cursos.devops.ac2.entity.Course;
import cursos.devops.ac2.value_object.CourseID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void ShouldCreateCourseProperly() {
        // Arrange
        Course course = new Course(
            1L,
            new CourseID("0000"),
            "Curso de Tecnologia",
            "Curso de tecnologia... autoexplicativo...",
            100d
        );

        // Action
        courseRepository.save(course);

        // Assertion
        assertEquals(courseRepository.findAll().size(), 1);

        assertEquals(courseRepository.getById(1L).hashCode(), course.hashCode());
    }

}
