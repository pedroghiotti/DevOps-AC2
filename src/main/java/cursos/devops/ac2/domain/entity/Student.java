package cursos.devops.ac2.domain.entity;

import cursos.devops.ac2.domain.enums.AccountType;
import cursos.devops.ac2.domain.value_object.Email;
import cursos.devops.ac2.domain.value_object.Password;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded private Email email;
    @Embedded private Password password;

    @Enumerated private AccountType accountType;
}
