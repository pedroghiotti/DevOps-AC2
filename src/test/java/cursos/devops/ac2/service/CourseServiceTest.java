package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseServiceTest {

    @Autowired CourseService courseService;

    @Test
    public void shouldCreateCourseProperly() {
        // Arrange
        CourseDTO courseDTO = new CourseDTO(
                "0000",
                "Curso de Tecnologia",
                "Curso de tecnologia... autoexplicativo...",
                100d
        );

        // Action
        courseService.createCourse(courseDTO);

        // Assertion
        assertEquals(courseService.getAllCourses().size(), 1);

        assertEquals(Course.fromDTO(courseService.getCourseById(1L)).hashCode(), Course.fromDTO(courseDTO).hashCode());
    }

}
