package cursos.devops.ac2.value_object;

import cursos.devops.ac2.repository.CourseRepository;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseID {
    private String cid;

    public Boolean isValid() {
        // Regex pra validação:
        // Verifica que há exatamente 4 caracteres numéricos: (regra arbitrária)
        // fonte: https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
        return this.cid.matches("^[0-9]{4}$");
    }
}
