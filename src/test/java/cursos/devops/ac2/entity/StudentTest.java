package cursos.devops.ac2.entity;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.value_object.Email;
import cursos.devops.ac2.value_object.Password;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {

    @Test
    public void shouldLossleslyConvertToAndFromDTO() {
        // Arrange
        Student student = new Student("Student", new Email("student@institution.com"), new Password("testPass0rd123"));

        // Action
        StudentDTO studentDTO = StudentDTO.fromEntity(student);

        // Assertion
        assertEquals(true, student.equals(Student.fromDTO(studentDTO)));
    }

}
