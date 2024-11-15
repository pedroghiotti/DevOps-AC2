package cursos.devops.ac2.entity;

import cursos.devops.ac2.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"student"})
public class Student_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @NonNull
    @OneToOne
    private Course course;

    @Enumerated private CourseStatus status = CourseStatus.ACQUIRED;

    private Double grade;
}
