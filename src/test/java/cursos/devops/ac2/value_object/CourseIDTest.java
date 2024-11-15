package cursos.devops.ac2.value_object;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseIDTest {

    @Test
    public void ShouldValidateProperCID() {
        // Arrange
        CourseID testCID = new CourseID("0009");

        // Action
        Boolean isValid = testCID.isValid();

        // Assertion
        assertEquals(isValid, true);
    }

    @Test
    public void ShouldInvalidateShorterThan4Characters() {
        // Arrange
        CourseID testCID = new CourseID("000");

        // Action
        Boolean isValid = testCID.isValid();

        // Assertion
        assertEquals(isValid, false);
    }
}
