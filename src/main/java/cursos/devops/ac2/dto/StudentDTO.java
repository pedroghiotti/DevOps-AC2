package cursos.devops.ac2.dto;

import cursos.devops.ac2.entity.Student;
import cursos.devops.ac2.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String name;
    private int coins;
    private String email_address;
    private String password;
    private AccountType accountType;

    public static StudentDTO fromEntity(Student student) {
        return new StudentDTO(
                student.getName(),
                student.getCoins(),
                student.getEmail().getAddress(),
                student.getPassword().getPassword(),
                student.getAccountType()
        );
    }
}
