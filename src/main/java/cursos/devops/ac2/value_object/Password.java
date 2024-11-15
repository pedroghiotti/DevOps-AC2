package cursos.devops.ac2.value_object;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    private String password;

    public Boolean isValid() {
        // Regex pra validação de senha:
        // Verifica que há pelo menos 8 caracteres + 1 letra + 1 número
        // fonte: https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
        return this.password.matches("^(?=.*[A-Za-z\\d@$!%*#?&])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
