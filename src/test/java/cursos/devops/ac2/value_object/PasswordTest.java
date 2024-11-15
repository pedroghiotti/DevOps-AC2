package cursos.devops.ac2.value_object;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PasswordTest {

    @Test
    public void ShouldValidateProperPassword() {
        // Arrange
        Password testPassword = new Password("Pw!testpw1");

        // Action
        Boolean isValid = testPassword.isValid();

        //Assert
        assertEquals(isValid, true);
    }

    @Test
    public void ShouldInvalidateShorterThan8Characters() {
        // Arrange
        Password testPassword = new Password("Abc@123");

        // Action
        Boolean isValid = testPassword.isValid();

        //Assert
        assertEquals(isValid, false);
    }

}
