package cursos.devops.ac2.repository;

import cursos.devops.ac2.entity.Coupon;
import cursos.devops.ac2.entity.Student;
import cursos.devops.ac2.enums.AccountType;
import cursos.devops.ac2.value_object.Email;
import cursos.devops.ac2.value_object.Password;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void ShouldCreateStudentProperly() {
        // Arrange
        Student student = new Student();
        student.setId(1L);
        student.setName("Student");
        student.setPassword(new Password("password"));
        student.setEmail(new Email("student@institution.com"));
        student.setCoins(10);
        student.setAccountType(AccountType.STANDARD);

        // Action
        studentRepository.save(student);

        // Assertion
        assertEquals(studentRepository.findAll().size(), 1);

        assertEquals(studentRepository.getById(1L).toString(), student.toString());
    }

}
