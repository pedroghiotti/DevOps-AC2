package cursos.devops.ac2.value_object;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String address;

    public Boolean isValid() {
        // Regex pra validação (simples) de email:
        // Verifica que há texto + @ + texto + . + texto
        // fonte: https://stackoverflow.com/questions/50330109/simple-regex-pattern-for-email
        return this.address.matches("^[^@]+@[^@]+\\.[^@]+$");
    }
}
