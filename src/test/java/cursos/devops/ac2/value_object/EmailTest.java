package cursos.devops.ac2.value_object;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTest {

    @Test
    public void ShouldValidateRealEmailAddress() {
        // Arrange
        // Usando endereço de email real
        Email testEmail = new Email("pedro.ghiotti.m@gmail.com");

        // Action
        Boolean isValid = testEmail.isValid();

        // Assertion
        assertEquals(isValid, true);
    }

    @Test
    public void ShouldInvalidateNoDomainSpecified() {
        // Arrange
        Email testEmail = new Email("test@.com");

        // Action
        Boolean isValid = testEmail.isValid();

        // Assertion
        assertEquals(isValid, false);
    }
}
