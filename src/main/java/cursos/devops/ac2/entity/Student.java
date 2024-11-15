package cursos.devops.ac2.entity;

import cursos.devops.ac2.dto.CouponDTO;
import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.enums.AccountType;
import cursos.devops.ac2.value_object.Email;
import cursos.devops.ac2.value_object.Password;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated private AccountType accountType = AccountType.STANDARD;

    private int coins = 0;

    @NonNull private String name;
    @NonNull @Embedded private Email email;
    @NonNull @Embedded private Password password;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student_Course> ownedCourses = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Coupon> ownedCoupons = new ArrayList<>();

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.getName();
        this.coins = studentDTO.getCoins();
        this.email = new Email(studentDTO.getEmail_address());
        this.password = new Password(studentDTO.getPassword());
        this.accountType = studentDTO.getAccountType();
    }

    public static Student fromDTO(StudentDTO studentDTO) {
        return new Student(studentDTO);
    }

}
