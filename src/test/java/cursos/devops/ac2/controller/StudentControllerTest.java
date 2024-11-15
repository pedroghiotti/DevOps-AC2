package cursos.devops.ac2.controller;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.enums.AccountType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentControllerTest {

    @Autowired StudentController studentController;

    @Test
    public void shouldCreateStudentProperly() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO("", 0, "", "", AccountType.STANDARD);

        // Action
        studentController.createStudent(studentDTO);

        // Assertion
        assertEquals(true, studentDTO.equals(studentController.getStudents().get(0)));
    }

}
