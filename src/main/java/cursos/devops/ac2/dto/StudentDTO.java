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
    private Long id;
    private String name;
    private String email_address;
    private String password;
    private AccountType accountType;

    public static StudentDTO fromEntity(Student student) {
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail().getAddress(),
                student.getPassword().getPassword(),
                student.getAccountType()
        );

        return studentDTO;
    }
}
